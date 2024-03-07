package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.UserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.UserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.impl.BalanceOperationService;
import core.basesyntax.strategy.impl.PurchaseOperationService;
import core.basesyntax.strategy.impl.ReturnOperationService;
import core.basesyntax.strategy.impl.SupplyOperationService;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/fruits.csv";
    private static final String toFile = "src/main/resources/report.csv";
    private static final Map<Operation, OperationService> operationMap = new HashMap<>();

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        operationMap.put(Operation.BALANCE, new BalanceOperationService(fruitDao));
        operationMap.put(Operation.PURCHASE, new PurchaseOperationService(fruitDao));
        operationMap.put(Operation.SUPPLY, new SupplyOperationService(fruitDao));
        operationMap.put(Operation.RETURN, new ReturnOperationService(fruitDao));
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        UserService userService = new UserServiceImpl(fruitDao,
                readerService,
                parserService,
                writerService);
        userService.formReport(operationMap, fromFile, toFile);
    }
}
