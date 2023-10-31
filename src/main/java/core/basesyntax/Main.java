package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Parser;
import core.basesyntax.reporter.CsvReportGenerator;
import core.basesyntax.reporter.ReportGenerator;
import core.basesyntax.service.performer.TransactionPerformer;
import core.basesyntax.service.performer.TransactionPerformerImpl;
import core.basesyntax.service.reader.CsvFileReader;
import core.basesyntax.service.reader.FileReader;
import core.basesyntax.service.writer.CsvFileWriter;
import core.basesyntax.service.writer.FileWriter;
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
    private static final String PATH_READ = "fruit1.csv";
    private static final String PATH_WRITE = "fruit2.csv";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> dataLines = fileReader.readFile(PATH_READ);

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        TransactionPerformer transactionPerformer =
                new TransactionPerformerImpl(operationStrategy, fruitStorageDao);
        List<FruitTransaction> transactionList = Parser.parseListToTransactionList(dataLines);
        transactionPerformer.performTransactions(transactionList);

        ReportGenerator generatedReport = new CsvReportGenerator();
        String csvReport = generatedReport.generateReport(fruitStorageDao);

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeToFile(csvReport, PATH_WRITE);
    }
}
