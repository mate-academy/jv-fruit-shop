package core.basesyntax;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CompilerOfReport;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.FruitMovementParser;
import core.basesyntax.service.impl.Writer;
import core.basesyntax.storage.Dao;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.PostingStrategy;
import java.util.List;

public class Main {
    private static final String SOURCE_FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Dao dao = new FruitStorage();
        FileReader reader = new CsvFileReader();
        List<String[]> sourceData = reader.readCsvFile(SOURCE_FILE_NAME);
        Parser parser = new FruitMovementParser();
        List<FruitMovement> fruitMovements = parser.parse(sourceData);

        Strategy strategy = new PostingStrategy();
        for (FruitMovement movement: fruitMovements) {
            strategy.getPostingAccordingMovement(movement).makePosting(movement, dao);
        }
        ReportCreator reporter = new CompilerOfReport();
        String report = reporter.generateReport(dao);
        FileWriter writer = new Writer();
        writer.writeToFile(report, REPORT_FILE_NAME);
    }
}
