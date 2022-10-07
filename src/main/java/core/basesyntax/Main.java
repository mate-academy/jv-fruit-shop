package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.fileservice.FileReaderService;
import core.basesyntax.fileservice.FileWriterService;
import core.basesyntax.fileservice.impl.FileReaderServiceImpl;
import core.basesyntax.fileservice.impl.FileWriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessing;
import core.basesyntax.service.ReportCsvParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.OperationProcessingImpl;
import core.basesyntax.service.impl.ReportCsvParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/activities.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>() {
            {
                put(FruitTransaction.Operation.BALANCE,
                        new BalanceOperationHandler(fruitDao));
                put(FruitTransaction.Operation.PURCHASE,
                        new PurchaseOperationHandler(fruitDao));
                put(FruitTransaction.Operation.SUPPLY,
                        new SupplyOperationHandler(fruitDao));
                put(FruitTransaction.Operation.RETURN,
                        new ReturnOperationHandler(fruitDao));
            }
        };
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> strings = fileReaderService.readFromFile(READ_FROM_FILE);
        ReportCsvParser reportCsvParser = new ReportCsvParserImpl();
        List<FruitTransaction> parse = reportCsvParser.parse(strings);
        OperationProcessing fruitService = new OperationProcessingImpl(fruitDao, operationStrategy);
        for (FruitTransaction transaction : parse) {
            fruitService.count(transaction);
        }
        ReportGenerator creator = new ReportGeneratorImpl(fruitDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(creator.generateReport(), WRITE_TO_FILE);
    }
}
