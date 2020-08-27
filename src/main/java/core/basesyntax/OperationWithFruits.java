package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class OperationWithFruits {
    private static Storage range = new Storage();
    private static List<String> fruitsAvailable = range.getFruitTypes();
    private static DataValidation data = new DataValidation();
    private static Buy buyingOperation = new Buy();
    private static AddFruit addOperation = new AddFruit();

    public List<String> operationWithFruits(List<String> fruitsFromFile) throws Exception {
        data.dataValidation(fruitsFromFile);
        for (int i = 0; i < fruitsFromFile.size(); i++) {

            String operationType = fruitsFromFile.get(i).split(",")[0];
            switch (operationType) {
                case "s":
                    fruitsAvailable = addOperation
                            .fruitsAdd(fruitsFromFile.get(i));
                    break;
                case "b":
                    fruitsAvailable = buyingOperation
                            .buying(fruitsFromFile.get(i));
                    break;
                case "r":
                    fruitsAvailable = addOperation
                            .fruitsAdd(fruitsFromFile.get(i));
                    break;
                default:
                    break;
            }
        }
        return fruitsAvailable;
    }
}
