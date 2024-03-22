package core.basesyntax.service.parsefileinfo;

import core.basesyntax.service.functionalityexpansion.ActivityType;

public class TransactionParser {
    private static final int ACTIVITY_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    public FruitTransactionInfo parse(String activityString) {
        String[] activityTypeArray = activityString.split(SEPARATOR);
        ActivityType activityType = ActivityType
                .getByCode(activityTypeArray[ACTIVITY_INDEX]);
        String name = activityTypeArray[NAME_INDEX];
        int quantity = Integer.parseInt(activityTypeArray[QUANTITY_INDEX]);
        return new FruitTransactionInfo(activityType, name, quantity);
    }
}
