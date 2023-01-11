package core.basesyntax;

import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategyOperationImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurposeStrategyOperationImpl;
import core.basesyntax.strategy.impl.ReturnStrategyOperationImpl;
import core.basesyntax.strategy.impl.SupplyStrategyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputFileName = "src/main/resources/FruitStore.csv";
        final String outFileName = "src/main/resources/file.csv";
        //Strategy
        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap
                = new HashMap<>();
        operationOperationHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceStrategyOperationImpl());
        operationOperationHandlerMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyStrategyOperationImpl());
        operationOperationHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurposeStrategyOperationImpl());
        operationOperationHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnStrategyOperationImpl());
        OperationStrategy operationStrategy
                = new OperationStrategyImpl(operationOperationHandlerMap);
        //read
        List<FruitTransaction> readFromFile = new ReaderServiceImpl().readFromFile(inputFileName);
        //process data
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.calculateFruit(readFromFile);
        //report create
        ReportService reportService = new ReportServiceImpl();
        List<String[]> report = reportService.createReport();
        //write report data
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.parse(report,outFileName);
    }
}
