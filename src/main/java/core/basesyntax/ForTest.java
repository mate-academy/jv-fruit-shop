package core.basesyntax;

import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import shop.service.FileReaderImpl;
import shop.service.OperationsStrategy;
import shop.service.OperationsStrategyImpl;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;
import shop.service.operations.Balance;
import shop.service.operations.Operation;
import shop.service.operations.Purchase;
import shop.service.operations.Return;
import shop.service.operations.Supply;

public class ForTest {
    public static void main(String[] args) {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("b", new Balance());
        operationMap.put("s", new Supply());
        operationMap.put("p", new Purchase());
        operationMap.put("r", new Return());

        OperationsStrategy operationsStrategy = new OperationsStrategyImpl(operationMap);
        ShopService shop = new ShopServiceImpl(new FruitDaoImpl(), operationsStrategy);

        shop.fromFileToStorage(new FileReaderImpl().read("10.09.99"));
        shop.printReport();

    }
}
