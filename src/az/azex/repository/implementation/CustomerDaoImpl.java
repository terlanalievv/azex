package az.azex.repository.implementation;

import az.azex.domain.Customer;
import az.azex.repository.CustomerDao;
import az.azex.repository.DatabaseUtility;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private DataSource dataSource;

    public CustomerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> searchCustomers(String query) {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(SqlQueries.SEARCH_CUSTOMERS);
            // TODO add search param
            rs = ps.executeQuery();
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerCode(rs.getString("customer_code"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setIdcardNumber(rs.getString("id_card_prefix"));
                customer.setIdcardPrefix(rs.getString("id_card_number"));
                customer.setPhone1(rs.getString("phone1"));
                // TODO read other columns
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, ps, connection);
        }

        return customerList;
    }
}
