package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.ReportReader;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.ReportReaderImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.DecreaseStrategy;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.IncreaseStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String PATHNAME = "src/main/resources/data.csv";
    private static Map<Operation, OperationHandler> strategyMap;

    public static void main(String[] args) {
        // report reading - done
        ReportReader reportReader = new ReportReaderImpl();
        List<String> readFile = reportReader.readFile(PATHNAME);
        // process data - done
        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.processAll(readFile);
        // apply strategy
        FruitDao fruitDao = new FruitDaoImpl();
        mapBuilder(fruitDao);
        FruitStrategy fruitStrategy = new FruitStrategy(strategyMap);
        fruitStrategy.processData(fruitTransactions);
        // form a report
        // write a report
    }

    private static void mapBuilder(FruitDao fruitDao) {
        strategyMap = Map.of(
                Operation.BALANCE, new BalanceStrategy(fruitDao),
                Operation.PURCHASE, new DecreaseStrategy(fruitDao),
                Operation.SUPPLY, new IncreaseStrategy(fruitDao),
                Operation.RETURN, new IncreaseStrategy(fruitDao)
        );
    }
}
