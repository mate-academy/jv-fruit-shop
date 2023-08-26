package service.dao;

import java.util.List;
import model.FruitTransaction;

public class ParserImpl implements ParserFrom {
    static final int OPERATION_INDEX = 0;
    static final int FRUIT_INDEX = 1;
    static final int QUANTITY_INDEX = 2;
    static final String REGEX = ",";
    private final List<FruitTransaction> fruitTransactions;

    public ParserImpl(List<FruitTransaction> fruitTransactions) {
        this.fruitTransactions = fruitTransactions;
    }

    @Override
    public List<FruitTransaction> parsedToFruitTransaction(List<String> fromFile) {
        String [] transactionArr;
        for (String record:fromFile) {
            transactionArr = record.split(REGEX);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(transactionArr[OPERATION_INDEX].trim());
            fruitTransaction.setFruit(transactionArr[FRUIT_INDEX].trim());
            fruitTransaction.setQuantity(Integer.parseInt(transactionArr[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
