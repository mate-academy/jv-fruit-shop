package core.basesyntax.application;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplierOperationHandler;
import core.basesyntax.service.DataMapper;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportMapper;
import core.basesyntax.serviceimpl.CsvFileReader;
import core.basesyntax.serviceimpl.CsvFileWriter;
import core.basesyntax.serviceimpl.FruitMapper;
import core.basesyntax.serviceimpl.FruitSalesReportGenerator;
import core.basesyntax.serviceimpl.ReportToArrayConverter;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String FILE_TO_READ_LOCATION = "src/main/java/core/basesyntax/"
            + "filesForProcessing/fileToRead.csv";
    private static final String FILE_TO_WRITE_LOCATION = "src/main/java/core/basesyntax/"
            + "filesForProcessing/fileToWrite.csv";

    public static void main(String[] args) {
        DataReader csvFileReader = new CsvFileReader();
        List<String> strings = csvFileReader.readFile(
                FILE_TO_READ_LOCATION);

        DataMapper fruitMapper = new FruitMapper();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplierOperationHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(strings);
        OperationsStrategy operationsStrategy = new OperationsStrategy(handlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationsStrategy.performTransaction(fruitTransaction);
        }

        ReportGenerator reportGenerator = new FruitSalesReportGenerator();
        String report = reportGenerator.generateReport();

        ReportMapper reportMapper = new ReportToArrayConverter();
        String[] reportInLines = reportMapper.prepareReportForWriting(report);

        DataWriter csvFileWriter = new CsvFileWriter();
        csvFileWriter.writeToFile(reportInLines,
                FILE_TO_WRITE_LOCATION);
    }
}
