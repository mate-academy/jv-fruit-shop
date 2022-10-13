package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.fileservice.FileReaderService;
import core.basesyntax.fileservice.FileWriterService;
import core.basesyntax.fileservice.impl.FileReaderServiceImpl;
import core.basesyntax.fileservice.impl.FileWriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.service.ReportCsvParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.service.impl.ReportCsvParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE = "src/main/resources/activities.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
        
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> strings = fileReaderService.readFromFile(DATA_FILE);

        ReportCsvParser reportCsvParser = new ReportCsvParserImpl();
        List<FruitTransaction> transactions = reportCsvParser.parse(strings);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        OperationProcessor fruitService = new OperationProcessorImpl(fruitDao, operationStrategy);
        for (FruitTransaction transaction : transactions) {
            fruitService.process(transaction);
        }

        ReportGenerator generator = new ReportGeneratorImpl(fruitDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(generator.generateReport(), REPORT_FILE);
    }
}
