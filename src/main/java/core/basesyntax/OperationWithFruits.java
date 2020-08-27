package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class OperationWithFruits {
    private static FruitTypes range = new FruitTypes();
    private static List<String> rangeOfShop = range.getFruitTypes();
    private static DataValidation data = new DataValidation();
    private static Buy buyingOperation = new Buy();
    private static AddFruit addOperation = new AddFruit();

    public List<String> operationWithFruits(List<String> fruitsFromFile) throws Exception {
        data.dataValidation(fruitsFromFile, rangeOfShop);
        List<String> fruitsAvailable = new ArrayList<>();
        for (int i = 0; i < fruitsFromFile.size(); i++) {

            String operationType = fruitsFromFile.get(i).split(",")[0];
            switch (operationType) {
                case "s":
                    fruitsAvailable = addOperation
                            .fruitsAdd(fruitsFromFile.get(i), fruitsAvailable);
                    break;
                case "b":
                    fruitsAvailable = buyingOperation
                            .buying(fruitsAvailable, fruitsFromFile.get(i));
                    break;
                case "r":
                    fruitsAvailable = addOperation
                            .fruitsAdd(fruitsFromFile.get(i), fruitsAvailable);
                    break;
                default: break;
            }
        }
        return fruitsAvailable;
    }
}
