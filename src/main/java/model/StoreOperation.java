package model;

import java.util.HashMap;
import java.util.Map;

public enum StoreOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, StoreOperation> OPERATION_BY_LETTER = new HashMap<>();
    static {
        for (StoreOperation o : values()) {
            OPERATION_BY_LETTER.put(o.storeOperation, o);
        }
    }

    private String storeOperation;

    StoreOperation(String storeOperation) {
        this.storeOperation = storeOperation;
    }

    public String getStoreOperation() {
        return storeOperation;
    }

    public static StoreOperation valueOfOperation(String storeOperation) {
        if (OPERATION_BY_LETTER.containsKey(storeOperation)) {
            return OPERATION_BY_LETTER.get(storeOperation);
        }
        throw new RuntimeException("This is unknown operation");
    }
}
