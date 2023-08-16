import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import service.ParserService;
import service.WriterService;
import service.impl.FruitServiceImpl;
import service.impl.ParserServiceCsvImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;
import strategy.TransactionStrategyImpl;

public class Main {
    private static final String PATH_FROM_FILE = "src/main/resources/inputData.csv";
    private static final String PATH_TO_FILE = "src/main/resources/fruitReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile(PATH_FROM_FILE);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        ParserService parserService = new ParserServiceCsvImpl();
        List<FruitTransaction> fruits = parserService.parseData(data);
        FruitService fruitService = new FruitServiceImpl(new FruitDaoImpl(),
                new TransactionStrategyImpl(operationHandlerMap));
        fruitService.processTransactions(fruits);
        List<String> reportList = fruitService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(PATH_TO_FILE, reportList);
    }
}
