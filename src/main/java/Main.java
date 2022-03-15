import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import operation.BalanceHandler;
import operation.Operation;
import operation.PurchaseHandler;
import operation.ReturnHandler;
import operation.SupplyHandler;
import service.Reader;
import service.ReaderImpl;
import service.ReportCreator;
import service.ReportCreatorImpl;
import service.Writer;
import service.WriterImpl;

public class Main {
    public static void main(String[] args) {
        Map<Fruit.Operation, Operation> operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceHandler());
        operationOperationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseHandler());
        operationOperationHandlerMap.put(Fruit.Operation.RETURN, new ReturnHandler());
        operationOperationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyHandler());
        Reader reader = new ReaderImpl();
        String line = reader.read();
        List<Fruit> fromCsvRow = reader.getFromCsvRow(line);
        for (Fruit fruit : fromCsvRow) {
            Operation operationHandler = operationOperationHandlerMap.get(fruit.getOperation());
            operationHandler.proceed(fruit);
        }
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        List<Fruit> fruitList = fruitShopDao.getAll();
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(fruitList);
        Writer writer = new WriterImpl();
        writer.write(report);
    }
}
