package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceHandler;
import core.basesyntax.handler.impl.PurchaseHandler;
import core.basesyntax.handler.impl.ReturnHandler;
import core.basesyntax.handler.impl.SupplyHandler;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.servises.FileReader;
import core.basesyntax.servises.FileWriter;
import core.basesyntax.servises.FruitService;
import core.basesyntax.servises.ParselToTransition;
import core.basesyntax.servises.ReportCreator;
import core.basesyntax.servises.impl.FileReaderImpl;
import core.basesyntax.servises.impl.FileWriterImpl;
import core.basesyntax.servises.impl.FruitServiceImpl;
import core.basesyntax.servises.impl.ParseToTransitionImpl;
import core.basesyntax.servises.impl.ReportCreatorImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        StorageDao dao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(dao));
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(dao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(dao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(dao));

        FileReader read = new FileReaderImpl();
        List<String> strings = read.readFromFile(PATH_FROM);

        ParselToTransition parse = new ParseToTransitionImpl();
        List<FruitTransaction> fruitTransitions = parse.interfaceTransactionParser(strings);

        Strategy strategy = new StrategyImpl(handlerMap);
        FruitService fruitTransition = new FruitServiceImpl(strategy);
        fruitTransition.applyTransaction(fruitTransitions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();

        FileWriter writeToFile = new FileWriterImpl();
        writeToFile.write(report, OUTPUT_FILE);

    }
}
