package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> data) {
        if (data == null) {
            throw new RuntimeException("Data from file is Empty");
        }
        List<FruitTransaction> transactionList = new ArrayList<>();
        data.remove(0);
        for (String element : data) {
            String[] word = element.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            switch (word[TRANSACTION_INDEX]) {
                case "b" : {
                    fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
                    break;
                }
                case "s" : {
                    fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
                    break;
                }
                case "r" : {
                    fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
                    break;
                }
                case "p" : {
                    fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                    break;
                }
                default : throw new RuntimeException("Transaction is falsh "
                        + word[TRANSACTION_INDEX]);
            }
            fruitTransaction.setFruit(word[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(word[QUANTITY_INDEX]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
