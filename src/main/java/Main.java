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
    public static void main(String[] args) {
        String pathFromFile = "src/main/resources/inputData.csv";
        FruitDao fruitDao = new FruitDaoImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile(pathFromFile);
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
                new TransactionStrategyImpl(operationHandlerMap), parserService);
        List<String> reportList = fruitService
                .createReport(fruits);
        String pathToFile = "src/main/resources/fruitReport.csv";
        WriterService writerService = new WriterServiceImpl();
        writerService.writeInFile(pathToFile, String.join("\n", reportList));
    }
}
