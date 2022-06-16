package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.DataParserService;
import core.basesyntax.strategy.OperationProcessingStrategy;
import java.util.List;
import java.util.function.Consumer;

public class DataHandlerServiceImpl implements DataHandlerService {
    private OperationProcessingStrategy operationProcessingStrategy;
    private DataParserService parserService;

    public DataHandlerServiceImpl(OperationProcessingStrategy operationProcessingStrategy,
                                  DataParserService parserService) {
        this.operationProcessingStrategy = operationProcessingStrategy;
        this.parserService = parserService;
    }

    @Override
    public void handleData() {
        List<FruitTransaction> fruitTransactions = parserService.parse();
        Consumer<FruitTransaction> consumer = transaction
                -> operationProcessingStrategy.get(transaction.getOperation())
                .doAction(transaction.getFruit(), transaction.getAmount());
        fruitTransactions.forEach(consumer);
    }
}
