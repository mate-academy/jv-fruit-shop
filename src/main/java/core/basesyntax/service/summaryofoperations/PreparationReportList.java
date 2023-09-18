package core.basesyntax.service.summaryofoperations;

import core.basesyntax.storage.FruitStorage;
import java.util.List;

public class PreparationReportList {
    private static final int TITLE_INDEX = 0;
    private final GeneralCalculation generalCalculation = new GeneralCalculation();
    private final FruitStorage fruitStorage = new FruitStorage();

    public List<String> createReportList() {
        List<String> generalAmountList =
                generalCalculation.calculateTotalAmount(fruitStorage.createStorage());
        generalAmountList.add(TITLE_INDEX,"fruit,quantity");
        return generalAmountList;
    }
}
