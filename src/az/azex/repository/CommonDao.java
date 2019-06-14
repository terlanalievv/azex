package az.azex.repository;

import az.azex.domain.FlexibleList;
import az.azex.domain.Order;

import java.util.List;
import java.util.Optional;

public interface CommonDao {

    List<FlexibleList> getAllFlexibleList();

    Optional<FlexibleList> getFlexibleListById(long id);

    Optional<FlexibleList> getFlexibleListByName(String name);

    List<Order> getCustomerOrders(long customerId);

}
