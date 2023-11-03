package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.serviceinterfaces.Mapper;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class MapperImpl implements Mapper {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_NAME_POS = 1;
    private static final int FRUIT_QUANTITY_POS = 2;
    private final OperationStrategy strategy;

    public MapperImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    private FruitTransaction getTransactionFromRow(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] rowWithTransaction = line.split(SPLITERATOR);
        fruitTransaction.setOperation(Operation.getOperation(
                rowWithTransaction[OPERATION_POS].trim()));
        fruitTransaction.setFruitName(rowWithTransaction[FRUIT_NAME_POS].trim());
        fruitTransaction.setQuantity(Integer
                .parseInt(rowWithTransaction[FRUIT_QUANTITY_POS].trim()));
        return fruitTransaction;
    }

    @Override
    public void mapData(List<String> data) {
        List<FruitTransaction> fruitTransactions = getFruitTransactions(data);
        fruitTransactions
                .forEach(t -> strategy.getOperationHandler(t.getOperation())
                        .updateValueInStorage(t));
    }

    private List<FruitTransaction> getFruitTransactions(List<String> data) {
        return data.stream()
                .map(this::getTransactionFromRow)
                .toList();
    }
}
