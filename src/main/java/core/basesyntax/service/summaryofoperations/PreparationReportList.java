package core.basesyntax.service.summaryofoperations;

import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class PreparationReportList {
    private static final int TITLE_INDEX = 0;
    private final GeneralCalculation generalCalculation;

    public PreparationReportList(GeneralCalculation generalCalculation) {
        this.generalCalculation = generalCalculation;

    }

    public List<String> createReportList(Map<Operation, Map<String, List<Integer>>> fruitsStorage) {
        List<String> generalAmountList =
                generalCalculation.calculateTotalAmount(fruitsStorage);
        generalAmountList.add(TITLE_INDEX,"fruit,quantity");
        return generalAmountList;
    }
}
