package az.azex.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer extends User implements Serializable {
    private static final long serialVersionUID = -5021015480511061514L;

    private String idcardPrefix;
    private String idcardNumber;
    private BigDecimal balance;

    public Customer() {
        this.balance = BigDecimal.ZERO;
    }

    public String getIdcardPrefix() {
        return idcardPrefix;
    }

    public void setIdcardPrefix(String idcardPrefix) {
        this.idcardPrefix = idcardPrefix;
    }

    public String getIdcardNumber() {
        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {
        this.idcardNumber = idcardNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
