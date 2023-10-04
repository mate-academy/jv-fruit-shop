package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> parseFruitData(String fruitData) {
        if (fruitData == null) {
            throw new NullPointerException("Input String is null!");
        }
        List<FruitTransaction> transactionList = new ArrayList<>();
        String[] lines = fruitData.split(System.lineSeparator());
        for (String line : lines) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] lineParts = line.split(SEPARATOR);
            fruitTransaction.setFruit(lineParts[FRUIT_TYPE]);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .fromCode(lineParts[OPERATION_TYPE]));
            fruitTransaction.setQuantity(Integer.parseInt(lineParts[QUANTITY]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }

    @Override
    public void processTransactionList(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList.isEmpty()) {
            throw new RuntimeException("Empty list: " + fruitTransactionList);
        }
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(fruitTransaction.getOperation());
            operationHandler.set(fruitTransaction);
        }
    }
}
