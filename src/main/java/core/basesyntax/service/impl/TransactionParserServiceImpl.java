package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> dataSheet) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataSheet.size(); i++) {
            String[] fields = dataSheet.get(i).split(",");

            FruitTransaction transaction = new FruitTransaction();
            transaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));

            String operation = fields[OPERATION_INDEX];
            if (operation.equals(FruitTransaction.Operation.BALANCE.getOperation())) {
                transaction.setOperation(FruitTransaction.Operation.BALANCE);
            }
            if (operation.equals(FruitTransaction.Operation.RETURN.getOperation())) {
                transaction.setOperation(FruitTransaction.Operation.RETURN);
            }
            if (operation.equals(FruitTransaction.Operation.PURCHASE.getOperation())) {
                transaction.setOperation(FruitTransaction.Operation.PURCHASE);
            }
            if (operation.equals(FruitTransaction.Operation.SUPPLY.getOperation())) {
                transaction.setOperation(FruitTransaction.Operation.SUPPLY);
            }
            transactions.add(transaction);
        }
        return transactions;
    }
}
