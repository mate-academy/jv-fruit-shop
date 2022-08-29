package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.cvs.CsvParserService;
import core.basesyntax.service.cvs.CsvParserServiceImpl;
import core.basesyntax.service.cvs.CsvReportService;
import core.basesyntax.service.cvs.CsvReportServiceImpl;
import core.basesyntax.service.cvs.FileReader;
import core.basesyntax.service.cvs.FileReaderImpl;
import core.basesyntax.service.cvs.FileWriter;
import core.basesyntax.service.cvs.FileWriterImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.report.TransactionService;
import core.basesyntax.service.report.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_IN = "src/resources/fruit-shop.csv";
    private static final String FILE_REPORT = "src/resources/fruit-shop-report.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> dataFromFile = reader.read(FILE_IN);
        CsvParserService csvParserService = new CsvParserServiceImpl();
        List<FruitTransaction> transactions = csvParserService.parse(dataFromFile);
        Map<Operation, OperationHandler> strategyMap = getMapStategy();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        TransactionService transactionService = new TransactionServiceImpl(operationStrategy);
        transactionService.process(transactions);
        CsvReportService csvReportService = new CsvReportServiceImpl();
        String report = csvReportService.getReport(Storage.fruits);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(FILE_REPORT, report);
    }

    private static Map<Operation, OperationHandler> getMapStategy() {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
        return map;
    }
}
