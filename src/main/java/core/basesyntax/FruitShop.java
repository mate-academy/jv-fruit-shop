package core.basesyntax;

import static core.basesyntax.model.OperationName.BALANCE;
import static core.basesyntax.model.OperationName.PURCHASE;
import static core.basesyntax.model.OperationName.RETURN;
import static core.basesyntax.model.OperationName.SUPPLY;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.ParserServiceImpl;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.StrategyServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        Map<OperationName, OperationHandler> actionHashMap = createDefaultActionMap();
        List<String> lines = readerService.readOperations(INPUT);
        List<FruitTransaction> fruitTransactions = parserService.parseOperations(lines);
        StrategyService strategyService = new StrategyServiceImpl();
        strategyService.processTransactions(actionHashMap, fruitTransactions);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeAll(OUTPUT);
    }

    private static Map<OperationName, OperationHandler> createDefaultActionMap() {
        Map<OperationName, OperationHandler> res = new HashMap<>();
        res.put(BALANCE, new BalanceOperationHandler());
        res.put(PURCHASE, new PurchaseOperationHandler());
        res.put(RETURN, new ReturnOperationHandler());
        res.put(SUPPLY, new SupplyOperationHandler());
        return res;
    }
}
