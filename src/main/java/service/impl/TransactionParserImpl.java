package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseAll(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String fruitTransactions: stringList) {
            String[] split = fruitTransactions.split(",");

            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(split[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));

            if (split[OPERATION_INDEX].equals("b")) {
                fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
            } else if (split[OPERATION_INDEX].equals("s")) {
                fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
            } else if (split[OPERATION_INDEX].equals("p")) {
                fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
            } else {
                fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
            }
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
