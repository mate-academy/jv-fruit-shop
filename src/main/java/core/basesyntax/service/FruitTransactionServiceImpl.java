package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parser.FruitTransactionParser;
import core.basesyntax.service.parser.FruitTransactionParserImpl;
import core.basesyntax.service.reader.ReaderService;
import core.basesyntax.service.writer.WriterService;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private ReaderService readerService;
    private WriterService writerService;
    private OperationStrategy strategy;
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private FruitTransactionParser parser = new FruitTransactionParserImpl();

    public FruitTransactionServiceImpl(ReaderService readerService,
                                       WriterService writerService,
                                       OperationStrategy strategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.strategy = strategy;
    }

    @Override
    public void process(String inputFile, String outputFile) {
        List<String> lines = readerService.readFromFile(inputFile);
        List<FruitTransaction> fruits = parser.parse(lines);
        for (FruitTransaction fruit : fruits) {
            strategy.getHandler(fruit).handle(fruit);
        }
        List<FruitTransaction> resultFruits = fruitTransactionDao.getAll();
        writerService.writeToFile(outputFile, resultFruits);
    }
}
