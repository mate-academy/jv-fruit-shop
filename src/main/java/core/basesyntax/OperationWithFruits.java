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
            String[] splitFruitsFromFile = fruitsFromFile.get(i).split(",");
            if (splitFruitsFromFile[0].startsWith("s")) {
                fruitsAvailable = addOperation.fruitsAdd(fruitsFromFile.get(i), fruitsAvailable);
            } else if (splitFruitsFromFile[0].startsWith("b")) {
                fruitsAvailable = buyingOperation.buying(fruitsAvailable, fruitsFromFile.get(i));
            } else {
                fruitsAvailable = addOperation.fruitsAdd(fruitsFromFile.get(i), fruitsAvailable);
            }
        }
        return fruitsAvailable;
    }
}
