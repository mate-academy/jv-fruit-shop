package core.fruitshop;

import core.fruitshop.dao.FruitDao;
import core.fruitshop.dao.FruitDaoImpl;
import core.fruitshop.model.FruitTransaction.Operation;
import core.fruitshop.service.FruitShopService;
import core.fruitshop.service.impl.DataHandlerImpl;
import core.fruitshop.service.impl.FileReaderImpl;
import core.fruitshop.service.impl.FileWriterImpl;
import core.fruitshop.service.impl.FruitShopServiceImpl;
import core.fruitshop.service.impl.ReportCreatorImpl;
import core.fruitshop.service.strategy.OperationHandler;
import core.fruitshop.service.strategy.impl.BalanceOperationHandler;
import core.fruitshop.service.strategy.impl.OperationStrategyImpl;
import core.fruitshop.service.strategy.impl.PurchaseOperationHandler;
import core.fruitshop.service.strategy.impl.ReturnOperationHandler;
import core.fruitshop.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        FruitDao dao = new FruitDaoImpl();
        map.put(Operation.BALANCE, new BalanceOperationHandler(dao));
        map.put(Operation.PURCHASE, new PurchaseOperationHandler(dao));
        map.put(Operation.RETURN, new ReturnOperationHandler(dao));
        map.put(Operation.SUPPLY, new SupplyOperationHandler(dao));
        FruitShopService fruitShopService = new FruitShopServiceImpl(new FileReaderImpl(),
                new DataHandlerImpl(new OperationStrategyImpl(map)), new ReportCreatorImpl(),
                new FileWriterImpl());
        String fileFrom = "src/main/resources/fromFile";
        String fileTo = "src/main/resources/toFile";
        fruitShopService.createDayReport(fileFrom, fileTo);
    }

}
