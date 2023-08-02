package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopProcessService;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopProcessServiceImpl;
import core.basesyntax.service.impl.TransactionParseServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/data.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CsvFileReaderService readFromFileService = new CsvFileReaderServiceImpl();
        List<String> dataFromFile = readFromFileService.readCsvFile(FILE_PATH);
        TransactionParseService transactionParseService = new TransactionParseServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                transactionParseService.getTransactionData(dataFromFile);
        OperationStrategyService operationStrategyService = new OperationStrategyImpl();
        ShopProcessService shopProcessService =
                new ShopProcessServiceImpl(operationStrategyService);
        shopProcessService.processData(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToCsvFile(REPORT_PATH,report);
    }
}
