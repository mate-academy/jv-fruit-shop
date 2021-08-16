package core.basesyntax.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Operation {
    public static final Map<String, Type> TYPE_MAP = new HashMap<>();

    static {
        TYPE_MAP.put("b", Type.BALANCE);
        TYPE_MAP.put("s", Type.SUPPLY);
        TYPE_MAP.put("p", Type.PURCHASE);
        TYPE_MAP.put("r", Type.RETURN);
    }

    private Type type;
    private String fruitName;
    private BigDecimal quantity;

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
        this.type = TYPE_MAP.get(type);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
