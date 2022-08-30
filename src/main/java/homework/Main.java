package homework;

import homework.dao.ReadService;
import homework.dao.WriteService;
import homework.dao.impl.ReaderServiceImpl;
import homework.dao.impl.WriterServiceImpl;
import homework.service.ParseTransactionsService;
import homework.service.ProcessDataService;
import homework.service.ReportService;
import homework.service.impl.FruitTransaction;
import homework.service.impl.ParseTransactionsServiceImpl;
import homework.service.impl.ProcessDataServiceImpl;
import homework.service.impl.ReportServiceImpl;
import homework.storage.Storage;
import homework.strategy.OperationStrategyImpl;
import homework.strategy.handler.BalanceOperationHandlerImpl;
import homework.strategy.handler.PurchaseOperationHandlerImpl;
import homework.strategy.handler.ReturnOperationHandlerImpl;
import homework.strategy.handler.SupplyOperationHandlerImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static final String DAILY_OPERATIONS_FILE
            = "src/main/java/homework/resourses/dailyoperations.csv";
    public static final String DAILY_REPORT_FILE
            = "src/main/java/homework/resourses/dailyreport.csv";

    public static void main(String[] args) {
        OperationStrategyImpl.operationsMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        OperationStrategyImpl.operationsMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        OperationStrategyImpl.operationsMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
        OperationStrategyImpl.operationsMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());

        ReadService file = new ReaderServiceImpl();
        Path pathInput = Paths.get(DAILY_OPERATIONS_FILE);
        List<String> fruitTransactionsString = file.read(pathInput);
        ParseTransactionsService parseTransactions = new ParseTransactionsServiceImpl();
        List<FruitTransaction> fruitTransactions = parseTransactions.parse(fruitTransactionsString);
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        processDataService.processData(fruitTransactions, OperationStrategyImpl.operationsMap);
        ReportService reportService = new ReportServiceImpl();
        WriteService writeService = new WriterServiceImpl();
        Path pathOutput = Paths.get(DAILY_REPORT_FILE);
        writeService.write(pathOutput, reportService.report(Storage.dataBase));
    }
}
