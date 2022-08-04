package core.basesyntax.transactionprocessorimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionprocessor.TransactionConstructor;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionConstructorImpl implements TransactionConstructor {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String line) {
        FruitTransaction transaction = new FruitTransaction();
        String[] splittedLine = line.split(",");
        transaction.setOperation(FruitTransaction.Operation
                .getOperationByFirstLetter(splittedLine[OPERATION_INDEX]));
        transaction.setFruitType(splittedLine[FRUIT_TYPE_INDEX]);
        transaction.setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
        return transaction;
    }
}
