package core.basesyntax;

import core.basesyntax.files.CsvFileReader;
import core.basesyntax.files.CsvFileWriter;
import core.basesyntax.files.FileReader;
import core.basesyntax.files.FileWriter;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/outputFile.csv";

    private static final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
    private static final FileReader csvFileReader = new CsvFileReader();
    private static final FileWriter csvFileWriter = new CsvFileWriter();
    private static final TransactionParser parser = new TransactionParserImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final OperationStrategy operationStrategy
            = new OperationStrategyImpl(operationHandlerMap);
    private static final FruitShopService fruitShopService
            = new FruitShopServiceImpl(operationStrategy);

    static {
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
    }

    public static void main(String[] args) {
        List<String> csvRowList = csvFileReader.readFileLines(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactionList = parser.parseCsvRows(csvRowList);
        fruitShopService.processTransactions(fruitTransactionList);
        csvFileWriter.writeToFile(reportService.createReport(), OUTPUT_FILE_NAME);
    }

}
