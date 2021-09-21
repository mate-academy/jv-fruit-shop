package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationTypeStrategy;
import core.basesyntax.operation.OperationTypeStrategyImpl;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.operation.ReturnHandler;
import core.basesyntax.operation.ShopOperationHandler;
import core.basesyntax.operation.SupplyHandler;
import core.basesyntax.service.FruitShopCsv;
import core.basesyntax.service.FruitShopDataParserImpl;
import core.basesyntax.service.FruitShopImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME = "src/main/resources/database.csv";

    public static void main(String[] args) {
        Map<OperationType, ShopOperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnHandler());

        FruitShopCsv fruitShopDaoCsv = new FruitShopImpl();
        List<String> file = fruitShopDaoCsv.readFile(FILE_NAME);

        FruitShopDataParserImpl fruitShopDataParser = new FruitShopDataParserImpl();
        List<TransactionDto> parsedFile = fruitShopDataParser.parse(file);

        OperationTypeStrategy operationTypeStrategy
                = new OperationTypeStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationTypeStrategy);
        fruitShopService.saveInformation(parsedFile);
        fruitShopService.report();
    }
}
