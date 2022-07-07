package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionConvertor;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionConvertorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.AdditionOperationHandler;
import core.basesyntax.strategy.handler.impl.SubtractionOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String pathToReadFile = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "outputFile.csv";
    private static final String pathToWriteFile = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "inputFile.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
    private static List<String> lines;

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        lines = fileReaderService.readFromFile(pathToReadFile);
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new AdditionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new AdditionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new SubtractionOperationHandler(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new AdditionOperationHandler(fruitShopDao));
        TransactionConvertor transactionConvertor = new TransactionConvertorImpl();
        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(new OperationStrategy(handlerMap));
        transactionProcessor.process(transactionConvertor.getFruitTransactions(lines));
        ReportCreator reportCreator = new ReportCreatorImpl(fruitShopDao);
        FileWriterServiceImpl writerService = new FileWriterServiceImpl();
        writerService.writeToFile(pathToWriteFile, reportCreator.create());
    }
}
