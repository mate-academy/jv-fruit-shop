package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitActivitiesModel;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitActivitiesModel> parse(List<String> transaction) {
        List<FruitActivitiesModel> transactions = new ArrayList<>();

        for (String strings : transaction) {
            FruitActivitiesModel fruitTransaction = new FruitActivitiesModel();
            String[] divided = strings.split(",");
            fruitTransaction.setOperation(FruitActivitiesModel.Operation
                    .getFruitByOperation(divided[OPERATION_INDEX]));
            fruitTransaction.setFruit(divided[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(divided[QUANTITY_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
