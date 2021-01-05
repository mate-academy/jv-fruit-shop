package core.basesyntax;

import core.basesyntax.model.entities.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.io.DataReader;
import core.basesyntax.service.io.ReportWriter;
import core.basesyntax.service.io.impl.CsvDataReader;
import core.basesyntax.service.io.impl.CsvReportWriter;

public class Main {
    public static void main(String[] args) {
        DataReader<Fruit> reader = new CsvDataReader<>("src/main/resources/input.csv");
        ReportWriter<Fruit> writer = new CsvReportWriter<>("src/main/resources/report.csv");
        FruitService service = new FruitService();
        service.importData(reader.readData());
        service.writeReport(writer);
    }
}
