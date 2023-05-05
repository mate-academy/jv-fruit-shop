package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final TransactionStrategy activitiesStrategy;
    private final Parser parser;

    public ShopServiceImpl(TransactionStrategy activitiesStrategy, Parser parser) {
        this.activitiesStrategy = activitiesStrategy;
        this.parser = parser;
    }

    @Override
    public void makeReport(List<String> dataBase) {
        for (String line: dataBase) {
            FruitTransaction fruitTransaction = parser.parse(line);
            activitiesStrategy.getTransaction(fruitTransaction.getOperation())
                    .transaction(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
