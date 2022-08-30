package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import core.basesyntax.service.FileReaderReport;
import core.basesyntax.service.FileWriterReport;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CompilerOfReport;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.FruitMovementParser;
import core.basesyntax.service.impl.Writer;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.storage.impl.FruitDaoImpl;
import core.basesyntax.strategy.GoodHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceMovementHandler;
import core.basesyntax.strategy.impl.PostingStrategy;
import core.basesyntax.strategy.impl.PurchaseMovementHandler;
import core.basesyntax.strategy.impl.ReturnMovementHandler;
import core.basesyntax.strategy.impl.SupplyMovementHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String SOURCE_FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileReaderReport reader = new CsvFileReader();
        List<String[]> sourceData = reader.readCsvFile(SOURCE_FILE_NAME);
        Parser parser = new FruitMovementParser();
        List<FruitMovement> fruitMovements = parser.parse(sourceData);

        Strategy strategy = new PostingStrategy(getHandlerMap(fruitDao));
        for (FruitMovement movement: fruitMovements) {
            strategy.getHandlerForMovement(movement.getType()).makePosting(movement);
        }
        Set<Map.Entry<Fruit, Integer>> entries = fruitDao.getEntries();
        ReportCreator reporter = new CompilerOfReport();
        String report = reporter.generateReport(entries);
        FileWriterReport writer = new Writer();
        writer.writeToFile(report, REPORT_FILE_NAME);
    }

    private static Map<MovementType, GoodHandler> getHandlerMap(FruitDao dao) {
        Map<MovementType, GoodHandler> strategies = new HashMap<>();
        strategies.put(MovementType.BALANCE, new BalanceMovementHandler(dao));
        strategies.put(MovementType.PURCHASE, new PurchaseMovementHandler(dao));
        strategies.put(MovementType.RETURN, new ReturnMovementHandler(dao));
        strategies.put(MovementType.SUPPLY, new SupplyMovementHandler(dao));
        return strategies;
    }
}
