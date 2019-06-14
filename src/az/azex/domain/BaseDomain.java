package az.azex.domain;

import java.io.Serializable;

public class BaseDomain implements Serializable {
    private static final long serialVersionUID = -7727433102534724353L;

    protected long id;
    protected Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
