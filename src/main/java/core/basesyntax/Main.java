package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.FruitService;
import service.FruitServiceImpl;
import service.writereadcsv.FruitServiceReaderCsv;
import service.writereadcsv.FruitServiceReaderCsvImp;
import service.writereadcsv.FruitServiceWriterCsv;
import service.writereadcsv.FruitServiceWriterCsvImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.operationhandlers.BalanceOperationHandlerImpl;
import strategy.operationhandlers.OperationHandler;
import strategy.operationhandlers.PurchaseOperationHandlerImpl;
import strategy.operationhandlers.ReturnOperationHandlerImpl;
import strategy.operationhandlers.SupplyOperationHandlerImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        OperationHandler balance = new BalanceOperationHandlerImpl();
        OperationHandler supply = new SupplyOperationHandlerImpl();
        OperationHandler retur = new ReturnOperationHandlerImpl();
        OperationHandler purchase = new PurchaseOperationHandlerImpl();
        Map<Fruit.Operation, OperationHandler> map = new HashMap<>();
        map.put(Fruit.Operation.BALANCE,balance);
        map.put(Fruit.Operation.SUPPLY,supply);
        map.put(Fruit.Operation.RETURN,retur);
        map.put(Fruit.Operation.PURCHASE,purchase);
        OperationStrategy strategy = new OperationStrategyImpl(map);
        FruitService fruitService = new FruitServiceImpl(strategy);
        FruitServiceReaderCsv readCsv = new FruitServiceReaderCsvImp();
        List<Fruit> list = readCsv.readAll();
        List<Fruit> report = fruitService.getReport(list);
        FruitServiceWriterCsv writerCsv = new FruitServiceWriterCsvImpl();
        writerCsv.writeAll(report);
        System.out.println("File report.csv created/replaced in src/main/resources/outputdate.");
    }
}
