package core.basesyntax.application;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplierOperationHandler;
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
    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReader();
        final CsvFileWriter csvFileWriter = new CsvFileWriter();
        FruitMapper fruitMapper = new FruitMapper();
        final ReportGenerator reportGenerator = new FruitSalesReportGenerator();
        final ReportMapper reportMapper = new ReportToArrayConverter();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplierOperationHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationsStrategy operationsStrategy = new OperationsStrategy(handlerMap);

        List<String> strings = csvFileReader.readFile(
                "src/main/java/core/basesyntax/filesForProcessing/fileToRead.csv");
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(strings);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationsStrategy.performTransaction(fruitTransaction);
        }
        String report = reportGenerator.generateReport();
        String[] reportInLines = reportMapper.prepareReportForWriting(report);
        csvFileWriter.writeToFile(reportInLines,
                "src/main/java/core/basesyntax/filesForProcessing/fileToWrite.csv");

    }
}
