package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.strategy.StrategyOptions;
import java.util.List;
import java.util.Map;

public class TransactionParserImpl implements TransactionParser {
    private static final String DELIMITER_BY_SENTENCE = ",";
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private StrategyOptions strategyOptions;

    public TransactionParserImpl(StrategyOptions strategyOptions) {
        this.strategyOptions = strategyOptions;
    }

    @Override
    public Map<String, Integer> saveToDb(List<String> strings) {
        String[] message;
        for (int i = 1; i < strings.size(); i++) {
            message = strings.get(i).split(DELIMITER_BY_SENTENCE);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .fromCode(message[OPERATION_POSITION]));
            fruitTransaction.setFruit(message[FRUIT_POSITION]);
            fruitTransaction.setQuantity(Integer.parseInt(message[QUANTITY_POSITION]));
            strategyOptions.get(fruitTransaction.getOperation()).handler(fruitTransaction);
        }
        return Storage.storage;
    }
}
