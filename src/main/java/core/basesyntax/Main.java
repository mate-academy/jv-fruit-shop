package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.servce.Calculations;
import core.basesyntax.servce.FileReader;
import core.basesyntax.servce.Parser;
import core.basesyntax.servce.FileWriter;
import core.basesyntax.servce.ReportCreator;
import core.basesyntax.servce.impl.CompilerOfReport;
import core.basesyntax.servce.impl.FruitMovementParser;
import core.basesyntax.servce.impl.CsvFileReader;
import core.basesyntax.servce.impl.Writer;
import core.basesyntax.storage.Dao;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.PostingStrategy;

import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static final  String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader reader = new CsvFileReader();
        List<String[]> sourceData = reader.readCsvFile(SOURCE_FILE_NAME);
        Parser parser = new FruitMovementParser();
        List<FruitMovement> fruitMovements = parser.parse(sourceData);
        Dao dao = new FruitStorage();
        Strategy strategy = new PostingStrategy();
        for (FruitMovement movement: fruitMovements) {
            strategy.getPostingAccordingMovement(movement).makePosting(movement, dao);
        }


        Map<Fruit, Integer> dayResults = new Calculations().generateReport(fruitMovements);
        ReportCreator reporter = new CompilerOfReport();
        String report = reporter.createReport(dayResults);
        FileWriter writer = new Writer();
        writer.writeToFile(report, REPORT_FILE_NAME);
    }
}
