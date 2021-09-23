package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitRecordDto {
    private final Type type;
    private final String fruit;
    private final int amount;

    public FruitRecordDto(Type type, String fruit, int amount) {
        this.type = type;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Type> typesOfMap = new HashMap<>();

        static {
            for (Type type : Type.values()) {
                typesOfMap.put(type.getType(), type);
            }
        }

        private String type;

        Type(String s) {
            this.type = s;
        }

        public static Type get(String type) {
            return typesOfMap.get(type);
        }

        public String getType() {
            return type;
        }
    }
}
