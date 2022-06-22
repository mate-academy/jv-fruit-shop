import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CreateReport;
import service.DataHandler;
import service.FileReaderService;
import service.FileWriterService;
import service.impl.CreateReportImpl;
import service.impl.DataHandlerImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import strategy.FruitHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnOperationHandler;
import strategy.impl.SupplyOperationHandler;

public class Main {
    private static final String OPERATION_PATH = "src/main/resources/operation.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, FruitTransaction.Operation> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put("b", FruitTransaction.Operation.BALANCE);
        transactionHandlerMap.put("s", FruitTransaction.Operation.SUPPLY);
        transactionHandlerMap.put("r", FruitTransaction.Operation.RETURN);
        transactionHandlerMap.put("p", FruitTransaction.Operation.PURCHASE);

        FruitsDao fruitsDao = new FruitsDaoImpl();
        Map<FruitTransaction.Operation, FruitHandler> fruitHandlerMap = new HashMap<>();
        fruitHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitsDao));
        fruitHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitsDao));

        FileReaderService fileReaderService = new FileReaderImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitHandlerMap);
        DataHandler dataHandler = new DataHandlerImpl(transactionHandlerMap);
        List<FruitTransaction> list =
                dataHandler.handleData(fileReaderService.readTheFruitsStorage(OPERATION_PATH));
        for (FruitTransaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .handleOperation(fruitTransaction);
        }
        CreateReport reportCreator = new CreateReportImpl();
        dataHandler.handleData(fileReaderService.readTheFruitsStorage(OPERATION_PATH));

        List<String> listOfFruits = reportCreator.createReport(fruitsDao.getCurrentFruitAmount());
        FileWriterService fileWriterService = new FileWriterImpl();
        fileWriterService.writeToFile(REPORT_PATH, listOfFruits);
    }
}
