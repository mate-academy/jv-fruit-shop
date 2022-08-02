package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.AdditionalOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.SubtractionOperation;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputData = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "ProductBalance.csv";
    private static final String outputData = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl(new Storage());
        FileReaderService readFile = new FileReaderServiceImpl();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new AdditionalOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new AdditionalOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new SubtractionOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.RETURN, new AdditionalOperation(fruitDao));

        ParserService parserService = new ParserServiceImpl();
        List<String> lines = readFile.readFromFile(inputData);
        FruitTransactionProcessor processor =
                new FruitTransactionProcessorImpl(new OperationStrategy(operationsMap));
        processor.process(parserService.parse(lines));

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl(fruitDao);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(outputData, reportCreatorService.create());
    }
}
