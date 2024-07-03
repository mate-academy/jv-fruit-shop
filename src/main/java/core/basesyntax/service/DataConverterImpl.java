package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    public static final int TYPE = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            String[] words = line.split(",");
            String type = words[TYPE];
            String fruit = words[FRUIT];
            String quantity = words[QUANTITY];
            switch (type) {
                case "b" -> transactions.add(new FruitTransaction(
                        FruitTransaction.Operation.BALANCE, fruit,
                        Integer.parseInt(quantity)));
                case "s" -> transactions.add(new FruitTransaction(FruitTransaction.Operation.SUPPLY,
                        fruit, Integer.parseInt(quantity)));
                case "p" -> transactions.add(new FruitTransaction(
                        FruitTransaction.Operation.PURCHASE, fruit,
                        Integer.parseInt(quantity)));
                case "r" -> transactions.add(new FruitTransaction(FruitTransaction.Operation.RETURN,
                        fruit, Integer.parseInt(quantity)));
                default -> { }
            }
        }
        return transactions;
    }
}
