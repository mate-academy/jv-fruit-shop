package core.basesyntax;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.strategy.OperationFactory;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.io.DataReader;
import core.basesyntax.service.io.ReportWriter;
import core.basesyntax.service.io.impl.CsvDataReader;
import core.basesyntax.service.io.impl.CsvReportWriter;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new CsvDataReader();
        ReportWriter writer = new CsvReportWriter();
        FruitService service =
                new FruitService(new OperationFactory<>(Warehouse.getFruitStorage()));

        service.importData(reader.readData(Path.of("src/main/resources/input.csv")));
        writer.writeReport(Path.of("src/main/resources/report.csv"), service.generateReport());
    }
}
