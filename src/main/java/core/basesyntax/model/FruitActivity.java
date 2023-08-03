package core.basesyntax.model;

import core.basesyntax.service.exceptions.UnsupportedActivityException;

import java.util.Arrays;

public class FruitActivity {
    private final Type activityType;
    private final String fruitName;
    private final Integer quantity;

    public FruitActivity(Type activityType, String fruitName, Integer quantity) {
        this.activityType = activityType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Type getActivityType() {
        return activityType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Type(String code) {
            this.code = code.replaceAll(" ", "");
        }

        public String getCode() {
            return code;
        }

        public static Type getType(String code) {
            return Arrays.stream(Type.values())
                    .filter(t -> t.getCode().equals(code))
                    .findFirst().orElseThrow(() -> new UnsupportedActivityException(code));
        }
    }
}
