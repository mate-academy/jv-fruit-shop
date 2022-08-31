package homework;

import homework.dao.ReadService;
import homework.dao.WriteService;
import homework.dao.impl.ReaderServiceImpl;
import homework.dao.impl.WriterServiceImpl;
import homework.model.FruitTransaction;
import homework.service.ParserTransactionsService;
import homework.service.ProcessDataService;
import homework.service.ReportService;
import homework.service.impl.ParserTransactionsServiceImpl;
import homework.service.impl.ProcessDataServiceImpl;
import homework.service.impl.ReportServiceImpl;
import homework.storage.Storage;
import homework.strategy.handler.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String DAILY_OPERATIONS_FILE
            = "src/main/java/homework/resourses/dailyoperations.csv";
    public static final String DAILY_REPORT_FILE
            = "src/main/java/homework/resourses/dailyreport.csv";

    public static void main(String[] args) {
        ReadService file = new ReaderServiceImpl();
        Path pathInput = Paths.get(DAILY_OPERATIONS_FILE);
        List<String> fruitTransactionsString = file.csvRead(pathInput);
        ParserTransactionsService parseTransactions = new ParserTransactionsServiceImpl();
        List<FruitTransaction> fruitTransactions = parseTransactions.parse(fruitTransactionsString);
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        processDataService.processData(fruitTransactions, newOperationsMap());
        ReportService reportService = new ReportServiceImpl();
        WriteService writeService = new WriterServiceImpl();
        Path pathOutput = Paths.get(DAILY_REPORT_FILE);
        writeService.csvWrite(pathOutput, reportService.report(Storage.dataBase));
    }

    private static Map<FruitTransaction.Operation, OperationHandler> newOperationsMap() {
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        return operations;
    }
}
