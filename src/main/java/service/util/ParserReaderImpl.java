package service.util;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class ParserReaderImpl implements ParserReader {
    static final int OPERATION_INDEX = 0;
    static final int FRUIT_INDEX = 1;
    static final int QUANTITY_INDEX = 2;
    static final String REGEX = ",";

    @Override
    public List<FruitTransaction> parsedToFruitTransaction(List<String> fromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String [] transactionArr;
        for (String record:fromFile) {
            transactionArr = record.split(REGEX);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .getByCode(transactionArr[OPERATION_INDEX].trim()));
            fruitTransaction.setFruit(transactionArr[FRUIT_INDEX].trim());
            fruitTransaction.setQuantity(Integer.parseInt(transactionArr[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
