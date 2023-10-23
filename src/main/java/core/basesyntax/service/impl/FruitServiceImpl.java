package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.TypeActivityStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String NEW_FILE = "newFile.CSV";

    private final ReaderService readerService;

    private final WriterService writerService;

    private final TypeActivityStrategy typeActivityStrategy;

    public FruitServiceImpl(ReaderService readerService, WriterService writerService,
                            TypeActivityStrategy typeActivityStrategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.typeActivityStrategy = typeActivityStrategy;
    }

    @Override
    public void writeReport(String file) {
        List<FruitTransaction> fruitTransactions = readerService.readFromFile(file);
        fruitTransactions
                .forEach(fruit -> typeActivityStrategy
                        .get(fruit.getOperation()).setAmountOfFruit(fruit));
        writerService.writeToFile(NEW_FILE);
    }
}
