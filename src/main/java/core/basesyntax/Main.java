package core.basesyntax;

import core.basesyntax.impl.ConverterServiceImpl;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.TransactionServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategyOperationImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseStrategyOperationImpl;
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
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategyOperationImpl());
        operationOperationHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnStrategyOperationImpl());
        OperationStrategy operationStrategy
                = new OperationStrategyImpl(operationOperationHandlerMap);
        //read
        List<String> readFromFile = new FileReaderServiceImpl().readFromFile(inputFileName);
        //process data
        List<FruitTransaction> fruitTransactions = new TransactionServiceImpl()
                .convertStringToFruitTransaction(readFromFile);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.calculateFruit(fruitTransactions);
        //report create
        ConverterService converterService = new ConverterServiceImpl();
        String report = new ReportServiceImpl().createReport(converterService.convertList());
        //write report data
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, outFileName);
    }
}
