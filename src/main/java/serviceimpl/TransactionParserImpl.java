package serviceimpl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX_SYMBOL = ",";
    private static final int TITLE_LINE = 1;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = TITLE_LINE; i < transactions.size(); i++) {
            fruitTransactionList.add(parseLine(transactions.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] data = line.split(REGEX_SYMBOL);
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getByChar(data[OPERATION_TYPE_INDEX]));
        fruitTransaction.setFruit(data[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
