package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class CsvFruitTransactionParserImpl implements FruitTransactionParser {
    public static final int ZERO_INDEX = 0;
    public static final int FIRST_INDEX = 1;
    public static final int SEKOND_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactions) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction : transactions) {
            String[] splitedLine = transaction.split(",");
            FruitTransaction.Operation operation =
                    new FruitTransaction().getOperation().get(splitedLine[ZERO_INDEX]);
            String fruit = splitedLine[FIRST_INDEX];
            int amount = Integer.parseInt(splitedLine[SEKOND_INDEX]);
            resultList.add(new FruitTransaction(
                    operation, fruit, amount));
        }
        return resultList;
    }
}
