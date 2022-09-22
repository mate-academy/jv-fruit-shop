package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitTransactionService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String> inputData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            String[] parameters = inputData.get(i).split(SPLITTER);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruitName(parameters[NAME_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(parameters[QUANTITY_INDEX]));
            Operation operation = Operation.getOperation(parameters[OPERATION_INDEX]);
            fruitTransaction.setOperation(operation);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
