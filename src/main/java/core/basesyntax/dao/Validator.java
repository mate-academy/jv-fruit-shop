package core.basesyntax.dao;

import java.util.List;

public class Validator {
    private ReaderService readerService = new ReaderServiceImpl();

    public void checkData(String filePath) {
        List<String> listOfInfo = readerService.getDataFromFile(filePath);
        String[] checkArray;
        for (String row:listOfInfo) {
            checkArray = row.split(",");
            if (checkArray.length != 3) {
                throw new RuntimeException("Incorrect input data from file " + filePath);
            }
            for (int i = 0; i < checkArray.length; i++) {
                if (checkArray[0].isEmpty() || checkArray[1].isEmpty()
                        || checkArray[2].isEmpty() || Integer.parseInt(checkArray[2]) < 0) {
                    throw new RuntimeException("Incorrect input data from file " + filePath);
                }
            }
        }
    }
}
