package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.service.CheckDataService;
import java.util.List;
import java.util.Map;

public class CheckDataServiceImpl implements CheckDataService {

    public static final int ZERO_NUMBER = 0;
    public static final int DATA_FILE_TITLE_INDEX = 0;
    public static final String COME_DELIMITER = ",";
    public static final int QUANTITY_INDEX = 2;

    @Override
    public void checkData(List<String> dataFromFileList) {
        if (dataFromFileList.size() == ZERO_NUMBER) {
            throw new RuntimeException("File contains no data");
        }

        if (!dataFromFileList.get(DATA_FILE_TITLE_INDEX).equals(Main.DATA_FILE_TITLE)) {
            throw new RuntimeException(
                    "The format of the data in the file "
                            + "needs to be checked - the "
                            + "title line does not match the template: "
                            + dataFromFileList.get(DATA_FILE_TITLE_INDEX));
        }

        for (String dataString : dataFromFileList) {
            String[] dataArray = dataString.split(COME_DELIMITER);
            if (!dataString.equals(Main.DATA_FILE_TITLE)
                    && Integer.parseInt(dataArray[QUANTITY_INDEX]) < ZERO_NUMBER) {
                throw new RuntimeException("The file contains a negative quantity : " + dataString);
            }
        }
    }

    @Override
    public void checkingDataMapBeforeSavingToDb(Map<String, Integer> balanceMap) {
        for (Map.Entry<String, Integer> stringIntegerEntry : balanceMap.entrySet()) {
            if (stringIntegerEntry.getValue() < ZERO_NUMBER) {
                throw new RuntimeException("The balance contains a negative value: "
                        + stringIntegerEntry.getKey()
                        + "-"
                        + stringIntegerEntry.getValue());
            }
        }
    }
}
