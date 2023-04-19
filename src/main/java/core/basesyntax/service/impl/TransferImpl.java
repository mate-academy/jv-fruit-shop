package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Transfer;
import core.basesyntax.strategy.OperationStrategy;

public class TransferImpl implements Transfer {
    private final Parser parser = new ParserImpl();

    @Override
    public void generateInfo(String[] info, OperationStrategy operationStrategy) {
        for (int i = 1; i < info.length; i++) {
            FruitTransaction fruitTransaction = parser.splitLine(info[i]);
            operationStrategy.get(fruitTransaction.getOperation()).process(fruitTransaction);
        }
    }
}
