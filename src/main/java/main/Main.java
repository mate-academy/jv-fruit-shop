package main;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.OperationHandler;
import operation.implementation.BalanceHandler;
import operation.implementation.PurchaseHandler;
import operation.implementation.ReturnHandler;
import operation.implementation.SupplyHandler;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.WriteService;
import service.implementation.ParseServiceImpl;
import service.implementation.ReaderServiceImpl;
import service.implementation.ReportServiceImpl;
import service.implementation.WriteServiceImpl;
import strategy.Strategy;
import strategy.StrategyImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruitInput.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        List<String> stringsFromInput = readerService.readFromFile(INPUT_FILE_PATH);
        final List<FruitTransaction> fruitTransactionList = parseService.parse(stringsFromInput);

        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.TransactionType,
                OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.TransactionType.BALANCE,
                new BalanceHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.TransactionType.PURCHASE,
                new PurchaseHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.TransactionType.RETURN,
                new ReturnHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.TransactionType.SUPPLY,
                new SupplyHandler(fruitDao));

        Strategy strategy = new StrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            strategy.process(fruitTransaction.getTransaction()).getHandler(fruitTransaction);
        }

        WriteService writeService = new WriteServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        writeService.writeToFile(REPORT_FILE_PATH, reportService.getReport(fruitDao.getAll()));
    }
}
