<%@ page import="az.azex.domain.DataTableResult" %>
<%@ page import="az.azex.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
    DataTableResult dataTableResult = new DataTableResult();

    dataTableResult.setRecordsFiltered(customerList.size());
    dataTableResult.setRecordsTotal(customerList.size());
    dataTableResult.setDraw(request.getParameter("draw"));

    String[][] data = new String[customerList.size()][6];
    for (int i = 0; i < customerList.size(); i++) {
        Customer customer = customerList.get(i);
        System.out.println(customer);
        data[i][0] = customer.getCustomerCode() + " " + customer.getName() + " " + customer.getSurname();
        data[i][1] = customer.getEmail();
        data[i][2] = customer.getIdcardPrefix() + customer.getIdcardNumber();
        data[i][3] = customer.getPhone1();
        data[i][4] = customer.getStatus().name();
        data[i][5] = "<a href='#' class='viewCustomer' customer_id='" + customer.getId() + "'>Bax</a>";
    }
    dataTableResult.setData(data);
    Gson gson = new Gson();
    out.print(gson.toJson(dataTableResult));
%>