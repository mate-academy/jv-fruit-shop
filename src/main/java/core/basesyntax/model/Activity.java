package core.basesyntax.model;

public class Activity {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    private final Type activityType;
    private final String fruitName;
    private final Integer quantity;

    public Activity(String activityLine) {
        String[] activitySplit = activityLine.split(SEPARATOR);
        this.activityType = getTypeFromString(activitySplit[ACTIVITY_TYPE_INDEX]
                .replaceAll(" ", ""));
        this.fruitName = activitySplit[FRUIT_NAME_INDEX];
        this.quantity = Integer.parseInt(activitySplit[QUANTITY_INDEX]);
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

    private Type getTypeFromString(String activityTypeSign) {
        if (activityTypeSign.equals("b")) {
            return Type.BALANCE;
        }
        if (activityTypeSign.equals("s")) {
            return Type.SUPPLY;
        }
        if (activityTypeSign.equals("p")) {
            return Type.PURCHASE;
        }
        if (activityTypeSign.equals("r")) {
            return Type.RETURN;
        }
        throw new RuntimeException(
                "Unsupported activity type sign. Sign type = " + activityTypeSign);
    }

    public enum Type {
        BALANCE, SUPPLY, PURCHASE, RETURN
    }
}
