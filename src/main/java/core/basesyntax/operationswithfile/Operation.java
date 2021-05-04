package core.basesyntax.operationswithfile;

import java.io.Serializable;

public class Operation implements Serializable {
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
        return "Operation type: " + operationType + " name: " + name + " count: " + count;
    }
}
