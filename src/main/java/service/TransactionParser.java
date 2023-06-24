package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.StoreOperation;

public class TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMA = ",";

    public List<FruitTransaction> parse(List<String> dataList) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataList.size(); i++) {
            String[] splitedRecord = dataList.get(i).split(COMA);
            transactions.add(new FruitTransaction(StoreOperation
                    .getByCode(splitedRecord[OPERATION_INDEX]), splitedRecord[FRUIT_INDEX],
                    Integer.parseInt(splitedRecord[AMOUNT_INDEX])));
        }
        return transactions;
    }
}
