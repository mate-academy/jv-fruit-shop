package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parseLine(List<String> inputData) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            String[] fields = inputData.get(i).split(SPLITTER);

            Transaction transaction = new Transaction();
            transaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));

            String operation = fields[OPERATION_INDEX];
            if (operation.equals(Operation.BALANCE.getOperation())) {
                transaction.setOperation(Operation.BALANCE);
            }
            if (operation.equals(Operation.RETURN.getOperation())) {
                transaction.setOperation(Operation.RETURN);
            }
            if (operation.equals(Operation.PURCHASE.getOperation())) {
                transaction.setOperation(Operation.PURCHASE);
            }
            if (operation.equals(Operation.SUPPLY.getOperation())) {
                transaction.setOperation(Operation.SUPPLY);
            }
            transactions.add(transaction);
        }
        return transactions;
    }
}
