package az.azex.repository.implementation;

import az.azex.domain.*;
import az.azex.repository.CommonDao;
import az.azex.repository.DatabaseUtility;
import com.sun.org.apache.xpath.internal.operations.Or;


import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommonDaoImpl implements CommonDao {

    private DataSource dataSource;

    public CommonDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<FlexibleList> getAllFlexibleList() {
        List<FlexibleList> allFlexibleList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs =  null;

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(SqlQueries.GET_ALL_FLEXIBLE_LIST);
            rs = ps.executeQuery();
            while(rs.next()) {
                long id = rs.getLong("id");
                Optional<FlexibleList> optionalFlexibleList = getFlexibleListById(id);
                if(optionalFlexibleList.isPresent()) {
                    allFlexibleList.add(optionalFlexibleList.get());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all flexible list", e);
        } finally {
            DatabaseUtility.close(rs, ps, connection);
        }

        return allFlexibleList;
    }

    @Override
    public Optional<FlexibleList> getFlexibleListById(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs =  null;
        Optional<FlexibleList> optionalFlexibleList = Optional.empty();

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(SqlQueries.GET_FLEXIBLE_LIST_BY_ID);
            ps.setLong(1, id);

            rs = ps.executeQuery();
            if(rs.next()) {
                FlexibleList flexibleList = new FlexibleList();
                flexibleList.setId(id);
                flexibleList.setName(rs.getString("name"));
                flexibleList.setStatus(Status.ACTIVE);

                ps = connection.prepareStatement(SqlQueries.GET_FLEXIBLE_LIST_ITEMS_BY_ID);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while(rs.next()) {
                    FlexibleListItem item = new FlexibleListItem();
                    item.setId(rs.getLong("id"));
                    item.setValueId(rs.getLong("value_id"));
                    item.setValueName(rs.getString("value_name"));
                    item.setListId(id);
                    item.setInsertDate(rs.getTimestamp("insert_date").toLocalDateTime());
                    item.setStatus(Status.ACTIVE);
                    flexibleList.add(item);
                }

                optionalFlexibleList = Optional.of(flexibleList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting flexible list by id", e);
        } finally {
            DatabaseUtility.close(rs, ps, connection);
        }

        return optionalFlexibleList;
    }

    @Override
    public Optional<FlexibleList> getFlexibleListByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {

        List<Order> orders = new ArrayList<>();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Elnara");
        customer.setSurname("Mammadova");
        customer.setEmail("elnara@mammadova.com");
        customer.setPassword("1234567");
        customer.setStatus(Status.ACTIVE);
        customer.setBalance(BigDecimal.valueOf(70.77));
        customer.setIdcardPrefix("AZE");
        customer.setIdcardNumber("13131313");

        Order order1 = new Order();
        order1.setId(1);
        order1.setAzexPaidAmount(BigDecimal.valueOf(100.18));
        order1.setCustomerPaidAmount(BigDecimal.valueOf(150.52));
        order1.setOrderDate(LocalDateTime.of(2019, 02, 18, 10, 00, 00));
        order1.setCustomer(customer);

        Order order2 = new Order();
        order2.setId(2);
        order2.setAzexPaidAmount(BigDecimal.valueOf(80.99));
        order2.setCustomerPaidAmount(BigDecimal.valueOf(100));
        order2.setOrderDate(LocalDateTime.of(2019, 01, 18, 10, 00, 00));
        order2.setCustomer(customer);

        Order order3 = new Order();
        order3.setId(2);
        order3.setAzexPaidAmount(BigDecimal.valueOf(50.49));
        order3.setCustomerPaidAmount(BigDecimal.valueOf(70.79));
        order3.setOrderDate(LocalDateTime.of(2019, 01, 28, 10, 00, 00));
        order3.setCustomer(customer);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        return orders;
    }
}
