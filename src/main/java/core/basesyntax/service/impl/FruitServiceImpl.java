package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.TypeActivityStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private ReaderService readerService;
    private WriterService writerService;

    private Map<FruitTransaction.Operation, TypeActivityStrategy> strategyMap;

    public FruitServiceImpl(Map<FruitTransaction.Operation, TypeActivityStrategy> strategyMap,
                            ReaderService readerService, WriterService writerService) {
        this.strategyMap = strategyMap;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void writeReport(String file) {
        List<FruitTransaction> fruitTransactions = readerService.readFromFile(file);
        fruitTransactions.stream()
                .forEach(fruit -> strategyMap.get(fruit.getOperation()));
        writerService.writeToFile("newFile.CSV");
    }
}
