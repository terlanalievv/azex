package az.azex.web.servlet;

import az.azex.crawler.Crawler;
import az.azex.crawler.TrendyolCrawler;
import az.azex.domain.*;
import az.azex.repository.CommonDao;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.implementation.CommonDaoImpl;
import az.azex.web.WebConstants;
import com.google.gson.Gson;
import com.sun.corba.se.spi.orb.PropertyParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User user = (User) request.getSession().getAttribute(WebConstants.ATTRIBUTE_USER);
       String page = user.getRoles().get(0).getDefaultPage();
        System.out.println("Useri " + page + " sehifesine forward ele");


        String action = request.getParameter("action");

        if(action == null) {
            action="index";
            page = "/WEB-INF/jsp/admin/index.jsp";
        }

        if(action != null && action.equalsIgnoreCase("viewOrders")) {
            DataSource dataSource = DatabaseUtility.getDataSource();
            CommonDao commonDao = new CommonDaoImpl(dataSource);
            List<Order> orders = commonDao.getCustomerOrders(1);
            request.setAttribute("customerOrders", orders);
            page = "/WEB-INF/jsp/admin/orders.jsp";
        } else if(action.equalsIgnoreCase("viewCities")) {
            page = "/WEB-INF/jsp/admin/city-list.jsp";
        } else if(action.equalsIgnoreCase("getFlexibleListItems")) {
            String listName = request.getParameter("name");
            String draw = request.getParameter("draw");
            int start = Integer.parseInt(request.getParameter("start"));
            int length = Integer.parseInt(request.getParameter("length"));

            FlexibleList flexibleList = (FlexibleList) getServletContext().getAttribute(listName);

            List<FlexibleListItem> filteredItems = flexibleList.getItemList().subList(start, start + length);

            DataTableResult dataTableResult = new DataTableResult();
            dataTableResult.setDraw(draw);
            dataTableResult.setRecordsTotal(flexibleList.getItemList().size());
            dataTableResult.setRecordsFiltered(flexibleList.getItemList().size());

            String[][] data = new String[filteredItems.size()][5];
            for (int i = 0; i < filteredItems.size(); i++) {
                FlexibleListItem item = filteredItems.get(i);
                data[i][0] = String.valueOf(i + 1);
                data[i][1] = String.valueOf(item.getId());
                data[i][2] = String.valueOf(item.getValueId());
                data[i][3] = item.getValueName();
                data[i][4] = item.getInsertDate().toString();
            }

            dataTableResult.setData(data);

            Gson gson = new Gson();
            String json = gson.toJson(dataTableResult);
            System.out.println("json = " + json);

            request.setAttribute("flexibleListItemsJson", json);
            page = "/WEB-INF/jsp/admin/flexible-list-items.jsp";
        } else if(action.equalsIgnoreCase("parse")) {
            String url = request.getParameter("url");
            Crawler crawler = new TrendyolCrawler();

            Optional<Product> optionalProduct = crawler.parse(url);

            if(optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                Gson gson = new Gson();
                String json = gson.toJson(product);
                request.setAttribute("productJson", json);
                page = "/WEB-INF/jsp/admin/product-json.jsp";
            }
        } else if(action.equalsIgnoreCase("new-order")) {
            page = "/WEB-INF/jsp/customer/new-order.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
