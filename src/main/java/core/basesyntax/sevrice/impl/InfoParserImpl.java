package core.basesyntax.sevrice.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevrice.InfoParser;
import java.util.ArrayList;
import java.util.List;

public class InfoParserImpl implements InfoParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int LINE_WHOSE_SHOULD_DELETE = 0;
    private static final int AMOUNT = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> parseToFruitTransactionList(List<String> dataFromFile) {
        dataFromFile.remove(LINE_WHOSE_SHOULD_DELETE);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            fruitTransactions.add(createTransaction(line.split(DELIMITER)));
        }
        return fruitTransactions;
    }

    private FruitTransaction createTransaction(String[] splitedString) {
        return new FruitTransaction(
                FruitTransaction.Operation.getByOperation(splitedString[OPERATION]),
                new Fruit(splitedString[FRUIT]),
                Integer.parseInt(splitedString[AMOUNT]));
    }
}
