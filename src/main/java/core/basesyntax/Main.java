package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.handler.Handler;
import core.basesyntax.handler.impl.Balance;
import core.basesyntax.handler.impl.Purchase;
import core.basesyntax.handler.impl.Return;
import core.basesyntax.handler.impl.Supply;
import core.basesyntax.models.FruitTransition;
import core.basesyntax.servises.FruitService;
import core.basesyntax.servises.ParselToTransition;
import core.basesyntax.servises.ReadFromFile;
import core.basesyntax.servises.ReportCreator;
import core.basesyntax.servises.WriteToFile;
import core.basesyntax.servises.impl.FruitServiceImpl;
import core.basesyntax.servises.impl.ParseToTransitionImpl;
import core.basesyntax.servises.impl.ReadFromFileImpl;
import core.basesyntax.servises.impl.ReportCreatorImpl;
import core.basesyntax.servises.impl.WriteToFileImpl;
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

        Map<FruitTransition.Operation, Handler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransition.Operation.BALANCE, new Balance(dao));
        handlerMap.put(FruitTransition.Operation.RETURN, new Return(dao));
        handlerMap.put(FruitTransition.Operation.SUPPLY, new Supply(dao));
        handlerMap.put(FruitTransition.Operation.PURCHASE, new Purchase(dao));

        ReadFromFile read = new ReadFromFileImpl();
        List<String> strings = read.readFromFile(PATH_FROM);

        ParselToTransition parse = new ParseToTransitionImpl();
        List<FruitTransition> fruitTransitions = parse.parseToFruit(strings);

        Strategy strategy = new StrategyImpl(handlerMap);
        FruitService fruitTransition = new FruitServiceImpl(strategy);
        fruitTransition.doOperationService(fruitTransitions);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();

        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.write(report, OUTPUT_FILE);

    }
}
