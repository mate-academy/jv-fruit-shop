package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class CsvFruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public List<FruitTransaction> parse(List<String> transactions) {

        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction : transactions) {
            String[] splitedLine = transaction.split(",");
            System.out.println(splitedLine[0]);
            FruitTransaction ft = new FruitTransaction();
            FruitTransaction.Operation operation =
                    new FruitTransaction().getOperation().get(splitedLine[0]);
            String fruit = splitedLine[1];
            int amount = Integer.parseInt(splitedLine[2]);
            FruitTransaction fruitTransaction = new FruitTransaction(
                    operation, fruit, amount);
            resultList.add(fruitTransaction);
        }
        return resultList;
    }
}
