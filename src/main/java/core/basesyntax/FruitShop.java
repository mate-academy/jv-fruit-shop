package core.basesyntax;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
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
        Map<Operation, OperationHandler> actionHashMap = createDefaultActionMap();
        List<String> lines = readerService.readOperations(INPUT);
        List<FruitTransaction> fruitTransactions = parserService.parseOperations(lines);
        StrategyService strategyService = new StrategyServiceImpl(actionHashMap);
        strategyService.processTransactions(fruitTransactions);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeAll(OUTPUT);
    }

    private static Map<Operation, OperationHandler> createDefaultActionMap() {
        Map<Operation, OperationHandler> res = new HashMap<>();
        res.put(BALANCE, new BalanceOperationHandler());
        res.put(PURCHASE, new PurchaseOperationHandler());
        res.put(RETURN, new ReturnOperationHandler());
        res.put(SUPPLY, new SupplyOperationHandler());
        return res;
    }
}
