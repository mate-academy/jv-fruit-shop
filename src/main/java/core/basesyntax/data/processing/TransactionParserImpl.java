package core.basesyntax.data.processing;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.implementations.DataValidatorImpl;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        DataValidator validator = new DataValidatorImpl();
        List<FruitTransaction> fruitInfo = new ArrayList<>();
        for (String line : lines) {
            String[] dataParts = line.split(",");
            validator.validate(dataParts);

            String operationCode = dataParts[OPERATION_INDEX].trim();
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.findOperation(operationCode);
            fruitInfo.add(new FruitTransaction(
                    operation, dataParts[FRUIT_INDEX],
                    Integer.parseInt(dataParts[AMOUNT_INDEX].trim())));
        }
        return fruitInfo;
    }
}
