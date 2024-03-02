package core.basesyntax.service;

import core.basesyntax.model.FruitInfo;
import core.basesyntax.model.FruitType;
import core.basesyntax.service.exception.EmptyFileException;

import java.util.ArrayList;
import java.util.List;

public class ConvertImpl implements Convert {

    private static final int ACTIVITIES_MARKER = 0;
    private static final int FRUIT_TYPE_MARKER = 1;
    private static final int QUANTITY_MARKER = 2;
    @Override
    public List<FruitInfo> convertToJavaObject(List<String> dataFileList) {
        try {
            if (dataFileList.isEmpty()) {
                throw new EmptyFileException("Read file is empty");
            }
            List<FruitInfo> fruitInfoList = new ArrayList<>();
            for (String s : dataFileList) {
                if (!s.equals("type,fruit,quantity")) {
                    String[] listAfterSplit = s.split(",");
                    FruitInfo fruitInfo = new FruitInfo();
                    fruitInfo.setActivities(listAfterSplit[ACTIVITIES_MARKER]);
                    fruitInfo.setFruitType(FruitType.valueOf(listAfterSplit[FRUIT_TYPE_MARKER].toUpperCase()));
                    fruitInfo.setQuantity(Integer.parseInt(listAfterSplit[QUANTITY_MARKER]));
                    fruitInfoList.add(fruitInfo);
                }
            }
            return fruitInfoList;
        } catch (EmptyFileException e) {
            System.err.println("Caught EmptyFileException: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
