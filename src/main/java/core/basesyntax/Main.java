package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String FILE_PATH_TO_READ = "src\\resources\\input.csv";
    private static final String FILE_PATH_TO_WRITE = "src\\resources\\report.csv";
    private static final HashMap<OperationType, Operation> STRATEGY_MAP = new HashMap<>();

    public static void main(String[] args) {
        fillOutMap();
        List<String> lines = new ReaderServiceImpl().readFromFile(FILE_PATH_TO_READ);
        List<FruitTransaction> fruitTransactionList = new ParseServiceImpl().parse(lines);
        new ProcessServiceImpl().processTransactions(fruitTransactionList, STRATEGY_MAP);
        String report = new ReportCreatorServiceImpl().createReport();
        new WriteServiceImpl().writeToFile(FILE_PATH_TO_WRITE, report);
    }

    private static void fillOutMap() {
        STRATEGY_MAP.put(OperationType.BALANCE, new BalanceOperation());
        STRATEGY_MAP.put(OperationType.PURCHASE, new PurchaseOperation());
        STRATEGY_MAP.put(OperationType.SUPPLY, new SupplyOperation());
        STRATEGY_MAP.put(OperationType.RETURN, new ReturnOperation());
    }
}
