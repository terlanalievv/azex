package az.azex.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -7302102645219804359L;

    private Customer customer;
    private LocalDateTime orderDate;
    private BigDecimal customerPaidAmount;
    private BigDecimal azexPaidAmount;

    public Order() {
        this.customer = null;
        this.orderDate = null;
        this.customerPaidAmount = BigDecimal.ZERO;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getCustomerPaidAmount() {
        return customerPaidAmount;
    }

    public void setCustomerPaidAmount(BigDecimal customerPaidAmount) {
        this.customerPaidAmount = customerPaidAmount;
    }

    public BigDecimal getAzexPaidAmount() {
        return azexPaidAmount;
    }

    public void setAzexPaidAmount(BigDecimal azexPaidAmount) {
        this.azexPaidAmount = azexPaidAmount;
    }
}
