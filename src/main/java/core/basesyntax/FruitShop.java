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
import core.basesyntax.strategy.Action;
import core.basesyntax.strategy.BalanceAction;
import core.basesyntax.strategy.PurchaseAction;
import core.basesyntax.strategy.ReturnAction;
import core.basesyntax.strategy.SupplyAction;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static final String SEPARATOR = ",";
    public static final String INPUT = "src/main/java/core/basesyntax/input.csv";
    public static final String OUTPUT = "src/main/java/core/basesyntax/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl(SEPARATOR);
        Map<OperationName, Action> actionHashMap = new HashMap<>();
        actionHashMap.put(BALANCE, new BalanceAction());
        actionHashMap.put(PURCHASE, new PurchaseAction());
        actionHashMap.put(RETURN, new ReturnAction());
        actionHashMap.put(SUPPLY, new SupplyAction());
        List<String> lines = readerService.readOperations(Path.of(INPUT));
        List<FruitTransaction> fruitTransactions = parserService.parseOperations(lines);
        StrategyService strategyService = new StrategyServiceImpl();
        strategyService.processTransactions(actionHashMap, fruitTransactions);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeAll(Path.of(OUTPUT));
    }
}
