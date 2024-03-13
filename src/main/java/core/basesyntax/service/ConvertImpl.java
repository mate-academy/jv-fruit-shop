package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfFruit;
import java.util.ArrayList;
import java.util.List;

public class ConvertImpl implements Convert {
    private static final String HEADER = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int ACTIVITIES_MARKER = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToJavaObject(List<String> dataFileList) {
        List<FruitTransaction> fruitInfoList = new ArrayList<>();
        for (String string : dataFileList) {
            if (string.equals(HEADER)) {
                continue;
            }
            String[] listAfterSplit = string.split(SEPARATOR);
            FruitTransaction fruitInfo = new FruitTransaction();

            String activityAbbreviation = listAfterSplit[ACTIVITIES_MARKER];
            Operation activity = null;
            for (Operation activityLoop : Operation.values()) {
                if (activityLoop.getAbbreviation().equals(activityAbbreviation)) {
                    activity = activityLoop;
                    break;
                }
            }
            if (activity == null) {
                throw new IllegalArgumentException("Unknown activity abbreviation: "
                        + activityAbbreviation);
            } else {
                fruitInfo.setOperation(activity);
            }

            fruitInfo.setTypeOfFruit(TypeOfFruit.valueOf(listAfterSplit[FRUIT_TYPE_INDEX]
                    .toUpperCase()));

            fruitInfo.setQuantity(Integer.parseInt(listAfterSplit[QUANTITY_INDEX]));
            fruitInfoList.add(fruitInfo);
        }
        return fruitInfoList;
    }
}
