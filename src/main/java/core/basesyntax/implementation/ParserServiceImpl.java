package core.basesyntax.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int TITLE = 0;

    @Override
    public List<FruitTransaction> parseRecords(List<String> records) {
        records.remove(TITLE);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String record : records) {
            String[] array = record.split(SEPARATOR);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(
                    FruitTransaction.Operation.getByCode(array[OPERATION]));
            transaction.setFruit(array[FRUIT]);
            transaction.setQuantity(Integer.parseInt(array[QUANTITY]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
