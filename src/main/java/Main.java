import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.Fruit;
import operation.*;
import service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Fruit.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceHandler());
        operationOperationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseHandler());
        operationOperationHandlerMap.put(Fruit.Operation.RETURN, new ReturnHandler());
        operationOperationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyHandler());


        Reader reader = new ReaderImpl();
        String line = reader.read();
        List<Fruit> fromCsvRow = reader.getFromCsvRow(line);
        for (Fruit fruit : fromCsvRow) {
            OperationHandler operationHandler = operationOperationHandlerMap.get(fruit.getOperation());
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
