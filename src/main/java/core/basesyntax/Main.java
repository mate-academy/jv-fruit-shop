package core.basesyntax;

import core.basesyntax.handler.BalanceTransactionHandler;
import core.basesyntax.handler.PurchaseTransaction;
import core.basesyntax.handler.ReturnTransaction;
import core.basesyntax.handler.SupplyTransaction;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.impl.DataStorageImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriteServiceImpl;
import core.basesyntax.impl.ReportCreatorServiceImpl;
import core.basesyntax.impl.TransactionProcessorServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataStorage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionProcessorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE_PATH =
            "src/main/resources/DataFile.csv";
    private static final String REPORT_FILE_PATH =
            "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader readerService = new FileReaderImpl();
        DataStorage dataConverterService = new DataStorageImpl();
        TransactionProcessorService transactionProcessorService =
                new TransactionProcessorServiceImpl(getOperationMap());
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        FileWriteService fileWriteService = new FileWriteServiceImpl();

        List<String> strings = readerService.readFromFile(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactions = dataConverterService.convertText(strings);
        transactionProcessorService.proccessing(fruitTransactions);
        String reportString = reportCreatorService.createReport();
        fileWriteService.writeToFile(reportString, REPORT_FILE_PATH);
    }

    private static Map<Operation, TransactionHandler> getOperationMap() {
        Map<Operation, TransactionHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceTransactionHandler());
        operationMap.put(Operation.RETURN, new ReturnTransaction());
        operationMap.put(Operation.PURCHASE, new PurchaseTransaction());
        operationMap.put(Operation.SUPPLY, new SupplyTransaction());
        return operationMap;
    }
}
