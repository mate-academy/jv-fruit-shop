package impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_CODE = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transaction) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String strings : transaction) {
            String[] fields = strings.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .Operation.getFruitByCode(fields[INDEX_CODE]));
            fruitTransaction.setFruit(fields[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
