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
        List<String> lines;
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl(new Storage());
        FileReaderService readFile = new FileReaderServiceImpl();
        lines = readFile.readFromFile(inputData);
        operationsMap.put(FruitTransaction.Operation.BALANCE, new AdditionalOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new AdditionalOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new SubtractionOperation(fruitDao));
        operationsMap.put(FruitTransaction.Operation.RETURN, new AdditionalOperation(fruitDao));

        ParserService parseService = new ParserServiceImpl();

        FruitTransactionProcessor analysisBalancesService =
                new FruitTransactionProcessorImpl(new OperationStrategy(operationsMap));
        analysisBalancesService.process(parseService.parse(lines));

        ReportCreatorService createService = new ReportCreatorServiceImpl(fruitDao);

        FileWriterService writeFileService = new FileWriterServiceImpl();
        writeFileService.writeToFile(outputData, createService.create());
    }
}
