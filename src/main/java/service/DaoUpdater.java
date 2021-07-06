package service;

import java.util.List;
import strategy.OperationTypes;

public class DaoUpdater {
    public static void updateData(List<String> data) {
        boolean firstTime = true;
        String[] splittedLine;
        for (String line : data) {
            splittedLine = line.split(",");
            if (firstTime) {
                firstTime = false;
                continue;
            }
            OperationTypes.getOperationHandler(splittedLine[0])
                    .changeBalance(splittedLine[1], Integer.parseInt(splittedLine[2]));
        }
    }
}
