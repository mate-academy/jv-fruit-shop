package model;

import java.util.HashMap;
import java.util.Map;

public enum StoreOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, StoreOperation> OPERATION_BY_CODE = new HashMap<>();
    static {
        for (StoreOperation o : values()) {
            OPERATION_BY_CODE.put(o.code, o);
        }
    }

    private String code;

    StoreOperation(String code) {
        this.code = code;
    }

    public String getStoreOperation() {
        return code;
    }

    public static StoreOperation getByCode(String code) {
        if (OPERATION_BY_CODE.containsKey(code)) {
            return OPERATION_BY_CODE.get(code);
        }
        throw new RuntimeException("This is unknown operation code: " + code);
    }
}
