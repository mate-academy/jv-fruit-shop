package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class Operation {
    public static final Map<String, Type> typeMap = new HashMap<>();

    static {
        typeMap.put("b", Type.BALANCE);
        typeMap.put("s", Type.SUPPLY);
        typeMap.put("p", Type.PURCHASE);
        typeMap.put("r", Type.RETURN);
    }

    private Type type;
    private String fruitName;
    private long quantity;

    public enum Type {
        BALANCE, SUPPLY, PURCHASE, RETURN;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = typeMap.get(type);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
