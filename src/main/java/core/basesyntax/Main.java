package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
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
import core.basesyntax.strategy.impl.PostingBalanceOfFruits;
import core.basesyntax.strategy.impl.PostingPurchaseOfFruit;
import core.basesyntax.strategy.impl.PostingReturnOfFruit;
import core.basesyntax.strategy.impl.PostingStrategy;
import core.basesyntax.strategy.impl.PostingSupplyOfFruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao dao = new FruitDaoImpl();
        FileReader reader = new CsvFileReader();
        List<String[]> sourceData = reader.readCsvFile(SOURCE_FILE_NAME);
        Parser parser = new FruitMovementParser();
        List<FruitMovement> fruitMovements = parser.parse(sourceData);

        Strategy strategy = new PostingStrategy(getStrategies());
        for (FruitMovement movement: fruitMovements) {
            strategy.getPostingAccordingMovement(movement.getType()).makePosting(movement, dao);
        }
        Map<Fruit, Integer> results = dao.getBalance();
        ReportCreator reporter = new CompilerOfReport();
        String report = reporter.generateReport(results);
        FileWriter writer = new Writer();
        writer.writeToFile(report, REPORT_FILE_NAME);
    }

    private static Map<MovementType, GoodHandler> getStrategies() {
        Map<MovementType, GoodHandler> strategies = new HashMap<>();
        strategies.put(MovementType.BALANCE, new PostingBalanceOfFruits());
        strategies.put(MovementType.PURCHASE, new PostingPurchaseOfFruit());
        strategies.put(MovementType.RETURN, new PostingReturnOfFruit());
        strategies.put(MovementType.SUPPLY, new PostingSupplyOfFruit());
        return strategies;
    }
}
