import Strategy.Impl.OperationStrategyImpl;
import Strategy.Impl.TransactionStrategyImpl;
import Strategy.OperationStrategy;
import Strategy.TransactionStrategy;
import dao.FruitsDao;
import dao.FruitsDaoImpl;
import model.FruitTransaction;
import service.FruitHandler;
import service.impl.BalanceOfFruits;
import serviceCSV.CreateReport;
import serviceCSV.DataHandler;
import serviceCSV.DataOperating;
import serviceCSV.FileReaderService;
import serviceCSV.FileWriterService;
import serviceCSV.impl.CreateReportImpl;
import serviceCSV.impl.DataHandlerImpl;
import serviceCSV.impl.DataOperatingImpl;
import serviceCSV.impl.FileReaderImpl;
import serviceCSV.impl.FileWriterImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATION_PATH = "src/main/resources/operation.csv";
    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<String, FruitTransaction.Operation> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put("b", FruitTransaction.Operation.BALANCE);
        transactionHandlerMap.put("s", FruitTransaction.Operation.SUPPLY);
        transactionHandlerMap.put("r", FruitTransaction.Operation.RETURN);
        transactionHandlerMap.put("p", FruitTransaction.Operation.PURCHASE);

        Map<FruitTransaction.Operation, FruitHandler> fruitHandlerMap = new HashMap<>();
        fruitHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOfFruits(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.SUPPLY, new BalanceOfFruits(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.RETURN, new BalanceOfFruits(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.PURCHASE, new BalanceOfFruits(fruitsDao));

        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(transactionHandlerMap);
        FileReaderService fileReaderService = new FileReaderImpl();
        DataOperating dataOperating = new DataOperatingImpl(transactionStrategy);
        FileWriterService fileWriterService = new FileWriterImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitHandlerMap);
        DataHandler dataHandler = new DataHandlerImpl(operationStrategy);
        CreateReport reportCreator = new CreateReportImpl();
        dataHandler.handleData(dataOperating.passFruitData(fileReaderService.readTheFruitsStorage("src/main/resources/operation.csv")));
        List<String> listOfFruits = reportCreator.createReport(fruitsDao.getCurrentFruitAmount());
        System.out.println(listOfFruits);
        System.out.println(fruitsDao.getCurrentFruitAmount());
        fileWriterService.writeToFile("src/main/resources/report.csv", String.valueOf(listOfFruits));
    }
}
