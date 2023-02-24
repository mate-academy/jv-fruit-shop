package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.TransactionParserService;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OPERATION_VALUE_INDEX = 2;
    private final FruitTransactionService fruitTransactionService;

    public TransactionParserServiceImpl(FruitTransactionService fruitTransactionService) {
        this.fruitTransactionService = fruitTransactionService;
    }

    @Override
    public void parseTransactions(String data) {
        String[] lines = data.split(System.lineSeparator());
        for (String line : lines) {
            String[] splitLine = line.split(",");
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(FruitTransaction.Operation
                    .of(splitLine[OPERATION_TYPE_INDEX]));
            transaction.setFruit(new Fruit(splitLine[FRUIT_NAME_INDEX]));
            transaction.setQuantity(Integer.parseInt(splitLine[OPERATION_VALUE_INDEX]));
            fruitTransactionService.add(transaction);
        }
    }
}
