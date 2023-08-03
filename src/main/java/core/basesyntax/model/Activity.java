package core.basesyntax.model;

import java.util.Arrays;

public class Activity {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    private final Type activityType;
    private final String fruitName;
    private final Integer quantity;

    public Activity(Type activityType, String fruitName, Integer quantity) {
        this.activityType = activityType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public static Activity makeActivity(String activityLine) {
        String[] activitySplit = activityLine.split(SEPARATOR);
        Type activityType = Type.getType(activitySplit[ACTIVITY_TYPE_INDEX]);
        String fruitName = activitySplit[FRUIT_NAME_INDEX];
        Integer quantity = Integer.parseInt(activitySplit[QUANTITY_INDEX]);
        return new Activity(activityType, fruitName, quantity);
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
                    .findFirst().orElseThrow();
        }
    }
}
