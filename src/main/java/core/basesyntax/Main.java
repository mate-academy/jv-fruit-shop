package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.servce.Calculations;
import core.basesyntax.servce.CsvFileReader;
import core.basesyntax.servce.CsvParser;
import core.basesyntax.servce.FileWriter;
import core.basesyntax.servce.ReportCreator;
import core.basesyntax.servce.impl.CompilerOfReport;
import core.basesyntax.servce.impl.Parser;
import core.basesyntax.servce.impl.Reader;
import core.basesyntax.servce.impl.Writer;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReader reader = new Reader();
        List<String[]> input = reader.readCsvFile();
        CsvParser parser = new Parser();
        List<FruitMovement> fruitMovements = parser.parse(input);
        Map<Fruit, Integer> dayResults = new Calculations().generateReport(fruitMovements);
        ReportCreator reporter = new CompilerOfReport();
        String report = reporter.createReport(dayResults);
        FileWriter writer = new Writer();
        writer.writeToFile(report);
    }
}
