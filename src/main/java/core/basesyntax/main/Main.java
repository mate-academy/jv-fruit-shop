package core.basesyntax.main;

import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.file.FileManager;
import core.basesyntax.file.impl.FileManagerImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.AccountHandler;
import core.basesyntax.strategy.AccountStrategy;
import core.basesyntax.strategy.AccountType;
import core.basesyntax.strategy.impl.AccountStrategyImpl;
import core.basesyntax.strategy.impl.BalanceAccountHandler;
import core.basesyntax.strategy.impl.PurchaseAccountHandler;
import core.basesyntax.strategy.impl.ReturnAccountHandler;
import core.basesyntax.strategy.impl.SupplyAccountHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<AccountType, AccountHandler> accountHandlerMap = new HashMap<>();
        accountHandlerMap.put(AccountType.BALANCE, new BalanceAccountHandler());
        accountHandlerMap.put(AccountType.SUPPLY, new SupplyAccountHandler());
        accountHandlerMap.put(AccountType.PURCHASE, new PurchaseAccountHandler());
        accountHandlerMap.put(AccountType.RETURN, new ReturnAccountHandler());

        AccountStrategy accountStrategy = new AccountStrategyImpl(accountHandlerMap);
        ShopService shopService = new ShopServiceImpl(new FruitDaoImpl(), accountStrategy);

        FileManager fileManager = new FileManagerImpl();
        List<String[]> inputData = fileManager.read("resources" + File.separator + "input.csv");
        List<String[]> outputData = shopService.process(inputData);
        fileManager.write(outputData, "resources" + File.separator + "output.csv");
    }
}
