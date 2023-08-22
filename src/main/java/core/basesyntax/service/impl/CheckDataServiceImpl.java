package core.basesyntax.service.impl;

import core.basesyntax.service.CheckDataService;
import java.util.List;

public class CheckDataServiceImpl implements CheckDataService {
    public static final int DATA_FILE_TITLE_INDEX = 0;
    public static final String COME_DELIMITER = ",";
    public static final int QUANTITY_INDEX = 2;
    public static final String DATA_FILE_TITLE = "type,fruit,quantity";

    @Override
    public void checkData(List<String> dataFromFileList) {
        if (dataFromFileList.isEmpty()) {
            throw new RuntimeException("File contains no data");
        }

        if (!dataFromFileList.get(DATA_FILE_TITLE_INDEX).equals(DATA_FILE_TITLE)) {
            throw new RuntimeException(
                    "The format of the data in the file "
                            + "needs to be checked - the "
                            + "title line does not match the template: "
                            + dataFromFileList.get(DATA_FILE_TITLE_INDEX));
        }

        for (String dataString : dataFromFileList) {
            String[] dataArray = dataString.split(COME_DELIMITER);
            if (!dataString.equals(DATA_FILE_TITLE)
                    && Integer.parseInt(dataArray[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("The file contains a negative quantity : " + dataString);
            }
        }
    }
}
