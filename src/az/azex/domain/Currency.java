package az.azex.domain;

import java.io.Serializable;

public class Currency extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 382536497686880163L;
    private String name;
    private int sortOrder;

    public Currency(long id, String name, int sortOrder) {
        this.id = id;
        this.name = name;
        this.sortOrder = sortOrder;
        this.status = Status.ACTIVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
