package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.converter.ConverterData;
import core.basesyntax.service.converter.ConverterDataImpl;
import core.basesyntax.service.reader.ReaderService;
import core.basesyntax.service.writer.WriterService;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private ReaderService readerService;
    private WriterService writerService;
    private Strategy strategy;
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private ConverterData converterData = new ConverterDataImpl();

    public FruitTransactionServiceImpl(ReaderService readerService,
                                       WriterService writerService, Strategy strategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.strategy = strategy;
    }

    @Override
    public void transaction(String inputFile, String outputFile) {
        List<String> readFromFile = readerService.readFromFile(inputFile);
        List<FruitTransaction> fruits = converterData.getFruitsOperation(readFromFile);
        for (FruitTransaction fruit : fruits) {
            strategy.getTypeOperation(fruit).operation(fruit, fruitTransactionDao);
        }
        List<FruitTransaction> resultFruits = fruitTransactionDao.getAll();
        writerService.writeToFile(outputFile, resultFruits);
    }
}
