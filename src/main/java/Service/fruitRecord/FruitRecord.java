package Service.fruitRecord;

import Service.Activities.TypeOfActivities;

public class FruitRecord {
    public static final int ACTIVITIES_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int FRUIT_VALUE_INDEX = 2;
    private TypeOfActivities operationType;
    private String fruit;
    private int amount;

    public FruitRecord(String[] fruitRecordData) {

        TypeOfActivities activities  = TypeOfActivities.BALANCE;
        this.operationType = activities.getActivities(fruitRecordData[ACTIVITIES_INDEX]);
        this.fruit = fruitRecordData[FRUIT_NAME_INDEX];
        this.amount = Integer.parseInt(fruitRecordData[FRUIT_VALUE_INDEX]);
    }

    public TypeOfActivities getOperationType() {
        return operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

}
