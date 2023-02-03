package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;


public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY = 2;


    private FruitTransaction.Operation typeOperationProvider(String str) {
        //TODO: Change switch with strategy pattern
        FruitTransaction fruitTransactionOperationProvider = new FruitTransaction();
        switch (str) {
            case "b":
                fruitTransactionOperationProvider.setOperation(FruitTransaction.Operation.BALANCE);
                break;
            case "s":
                fruitTransactionOperationProvider.setOperation(FruitTransaction.Operation.SUPPLY);
                break;
            case "p":
                fruitTransactionOperationProvider.setOperation(FruitTransaction.Operation.PURCHASE);
                break;
            case "r":
                fruitTransactionOperationProvider.setOperation(FruitTransaction.Operation.RETURN);
                break;
        }
        return fruitTransactionOperationProvider.getOperation();
    }

    public List<FruitTransaction> getFruitTransaction(List<String> transactions) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (int i = 1; i < transactions.size(); i++) {
            String[] array = transactions.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(typeOperationProvider(array[OPERATION]));
            fruitTransaction.setFruit(array[TYPE_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(array[QUANTITY]));
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }


}

