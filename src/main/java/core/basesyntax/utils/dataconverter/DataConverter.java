package core.basesyntax.utils.dataconverter;

import core.basesyntax.models.FruitTransaction;

import java.util.List;
import java.util.function.Function;

public class DataConverter implements IDataConverter {
    private static final String TRANSACTION_PARTS_SEPARATOR = ",";
    private static final int TRANSACTION_OPERATION_INDEX = 0;
    private static final int TRANSACTION_FRUIT_INDEX = 1;
    private static final int TRANSACTION_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> toFruitTransactions(List<String> transactionsStrings) {
        Function<String, FruitTransaction> fruitTransactionMapper = (transactionString) -> {
            String[] transactionParts = transactionString.split(TRANSACTION_PARTS_SEPARATOR);

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(transactionParts[TRANSACTION_OPERATION_INDEX]);
            String fruit = transactionParts[TRANSACTION_FRUIT_INDEX];
            int quantity = Integer.parseInt(transactionParts[TRANSACTION_QUANTITY_INDEX]);

            return new FruitTransaction(operation, fruit, quantity);
        };

        return transactionsStrings.stream().map(fruitTransactionMapper).toList();
    }
}
