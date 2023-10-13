package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

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
            switch (word[ZERO_INDEX]) {
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
                default : {
                    fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                }
            }
            fruitTransaction.setFruit(word[FIRST_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(word[SECOND_INDEX]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
