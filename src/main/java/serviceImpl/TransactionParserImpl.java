package serviceImpl;

import model.fruitActivitiesModel;
import service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<fruitActivitiesModel> parse(List<String> transaction) {
        List<fruitActivitiesModel> transactions = new ArrayList<>();

        for (String strings : transaction) {
            fruitActivitiesModel fruitTransaction = new fruitActivitiesModel();
            String[] divided = strings.split(",");
            fruitTransaction.setOperation(fruitActivitiesModel.Operation
                    .getFruitByOperation(divided[OPERATION_INDEX]));
            fruitTransaction.setFruit(divided[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(divided[QUANTITY_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}