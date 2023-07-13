package model;

public abstract class TransactionOperation {
    private String code;

    public TransactionOperation(String code) {
        this.code = code;
    }

    public TransactionOperation() {
    }

    public String getCode() {
        return code;
    }
}
