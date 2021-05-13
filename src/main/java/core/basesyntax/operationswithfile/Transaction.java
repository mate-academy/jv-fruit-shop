package core.basesyntax.operationswithfile;

public class Transaction {
    private String operationType;
    private String name;
    private int count;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Transaction type: " + operationType + " name: " + name + " count: " + count;
    }
}
