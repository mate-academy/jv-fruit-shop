package core.basesyntax.service.fruittransactionservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionMapperImpl implements FruitTransactionMapper {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFruitTransaction).collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = fruitTransaction
                .getOperationByFirstLetter(fields[INDEX_OF_OPERATION_TYPE]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[INDEX_OF_FRUIT_TYPE]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_OF_FRUIT_QUANTITY]));
        return fruitTransaction;
    }
}
