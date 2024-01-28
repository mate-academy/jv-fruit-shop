package core.basesyntax.fruitshop.impl;

import core.basesyntax.fruitshop.db.Storage;
import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.service.FruitShopService;
import core.basesyntax.fruitshop.service.ParserService;
import core.basesyntax.fruitshop.strategy.OperationHandler;
import core.basesyntax.fruitshop.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final ParserService parserService;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(ParserService parserService, OperationStrategy operationStrategy) {
        this.parserService = parserService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        return parserService.parse(lines);
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }

        return Storage.getInstance().getFruitStorage();
    }
}
