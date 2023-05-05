package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.FileReaderCsvImpl;
import core.basesyntax.service.impl.FileWriterCsvImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import core.basesyntax.service.strategy.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        FileReader fileReader = new FileReaderCsvImpl();
        FileWriter fileWriter = new FileWriterCsvImpl();
        TransactionStrategy activitiesStrategy = new TransactionStrategyImpl(activitiesHandlerMap);
        Parser parser = new ParserImpl();
        ShopService shopService = new ShopServiceImpl(activitiesStrategy, parser);

        List<String> dataBase = fileReader.readFromFile();
        shopService.makeReport(dataBase);
        fileWriter.writeToFile();
    }
}
