package core.basesyntax.model;

import core.basesyntax.service.Validator;
import core.basesyntax.service.operationtypes.OperationStrategy;
import core.basesyntax.service.operationtypes.Operations;
import java.util.List;

public class TransactionDto {
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;

    public void convertFromListToDb(List<String> fruitsData, OperationStrategy strategy) {
        Validator validator = new Validator();
        for (int i = 1; i < fruitsData.size(); i++) {
            String[] fruitInfo = fruitsData.get(i).split(SEPARATOR);
            validator.validate(fruitInfo);
            strategy.get(Operations.get(fruitInfo[OPERATION_TYPE]))
                    .apply(fruitInfo[FRUIT_TYPE], Integer.parseInt(fruitInfo[AMOUNT]));
        }
    }
}
