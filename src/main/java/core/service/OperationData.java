package core.service;

public class OperationData {
    private String operationType;
    private String product;
    private int number;

    public OperationData(String operationType, String product, int number) {
        this.operationType = operationType;
        this.product = product;
        this.number = number;
    }

    @Override
    public String toString() {
        return "OperationData{"
                + "operationType='" + operationType + '\''
                + ", product='" + product + '\''
                + ", number=" + number
                + '}';
    }

    public String getOperationType() {
        return operationType;
    }

    public String getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }
}
