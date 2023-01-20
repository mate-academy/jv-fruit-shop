package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.StoreOperation;

public class TransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String COMA = ",";
    private List<FruitTransaction> transactions = new ArrayList<>();

    public List<FruitTransaction> parse(List<String> dataList) {
        for (int i = 1; i < dataList.size(); i++) {
            transactions.add(new FruitTransaction(StoreOperation
                    .getByCode(dataList.get(i).split(COMA)[OPERATION]),
                    dataList.get(i).split(COMA)[FRUIT],
                    Integer.parseInt(dataList.get(i).split(COMA)[AMOUNT])));
        }
        return transactions;
    }
}
