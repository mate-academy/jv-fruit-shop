package core.basesyntax;

import com.opencsv.CSVWriter;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileCsvService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FileCsvServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.strategy.handler.ActivityHandler;
import core.basesyntax.service.strategy.handler.BalanceActivityHandler;
import core.basesyntax.service.strategy.handler.PurchaseActivityHandler;
import core.basesyntax.service.strategy.handler.ReturnActivityHandler;
import core.basesyntax.service.strategy.handler.SupplyActivityHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileCsvService fileService = new FileCsvServiceImpl();
        Map<Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Operation.BALANCE, new BalanceActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.SUPPLY, new SupplyActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.PURCHASE, new PurchaseActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.RETURN, new ReturnActivityHandler(fruitDao));
        List<String[]> list = getStock();
        try(CSVWriter csvFile = fileService.createCsvFile("stock.csv")) {
            csvFile.writeAll(list);
        } catch (IOException e) {
            throw new RuntimeException("Can't close file " + e);
        }
        FruitService fruitService = new FruitServiceImpl(fileService, activityHandlerMap);
        fruitService.toProcessActivities("stock.csv");
    }

    private static List<String[]> getStock() {
        List<String[]> list = new ArrayList<>();
        String[] header = {"type", "fruit", "quantity"};
        String[] record1 = {"b", "banana", "20"};
        String[] record2 = {"b", "apple", "100"};
        String[] record3 = {"s", "banana", "100"};
        String[] record4 = {"p", "banana", "13"};
        String[] record5 = {"r", "apple", "10"};
        String[] record6 = {"b", "apple", "20"};
        String[] record7 = {"p", "banana", "5"};
        String[] record8 = {"s", "banana", "50"};
        list.add(header);
        list.add(record1);
        list.add(record2);
        list.add(record3);
        list.add(record4);
        list.add(record5);
        list.add(record6);
        list.add(record7);
        list.add(record8);
        return list;
    }
}
