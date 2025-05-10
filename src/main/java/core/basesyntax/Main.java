package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.service.TransactionParseServiceImpl;
import core.basesyntax.service.filesoperation.FileReader;
import core.basesyntax.service.filesoperation.FileReaderImpl;
import core.basesyntax.service.filesoperation.FileWrite;
import core.basesyntax.service.filesoperation.FileWriteImpl;
import core.basesyntax.service.operationwithfruits.BalanceOperationHandler;
import core.basesyntax.service.operationwithfruits.OperationHandler;
import core.basesyntax.service.operationwithfruits.PurchaseOperationHandler;
import core.basesyntax.service.operationwithfruits.ReturnOperationHandler;
import core.basesyntax.service.operationwithfruits.SupplyOperationHandler;
import core.basesyntax.service.report.CsvReportServiceImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input_file";
    private static final String REPORT_FILE = "src/main/resources/report_file";

    public static void main(String[] arg) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao));
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao));
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao));
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategy);
        FileReader fileReader = new FileReaderImpl();
        List<String> dailyTransactionList = fileReader.read(INPUT_FILE);
        TransactionParseService parserService = new TransactionParseServiceImpl();
        List<FruitTransaction> transactionList = parserService
                .parse(dailyTransactionList);
        for (FruitTransaction fruitTransaction: transactionList) {
            operationStrategy.get(fruitTransaction.getOperation()).getOperation(fruitTransaction);
        }
        ReportService reportService = new CsvReportServiceImpl(storageDao);
        String report = reportService.createReport();
        FileWrite fileWriter = new FileWriteImpl();
        fileWriter.write(REPORT_FILE,report);
    }
}
