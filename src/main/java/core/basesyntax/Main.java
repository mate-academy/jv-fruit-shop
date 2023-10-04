package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataProcessorImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
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
    private static final String READ_FROM_FILE = "src/main/resources/InputFile.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = createMap();
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<String> fruits = readerService.readFromFile(READ_FROM_FILE);
        List<FruitTransaction> parsedFruits = parserService.parseData(fruits);
        dataProcessor.addDataToDB(parsedFruits);
        writerService.writeToFile(WRITE_TO_FILE, reportService.createReport());
    }

    private static Map<FruitTransaction.Operation, OperationHandler> createMap() {
        return Map.of(
               FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
               FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
               FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
               FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
    }
}
