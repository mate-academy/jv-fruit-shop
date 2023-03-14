package core.basesyntax;

import core.basesyntax.impl.CsvFileReader;
import core.basesyntax.impl.CsvFileWriter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.operation.Operations;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static final File ACTIVITIES = new File("src/main/resources/activities.csv");
    public static final File REPORT = new File("src/main/resources/report.csv");

    public static void main(String[] args) {
        FileReaderService csvFileReader = new CsvFileReader();
        List<String> data = csvFileReader.readFromFile(ACTIVITIES);

        Operations.fill();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        operationStrategy.accept(data);

        FileWriterService csvFileWriter = new CsvFileWriter();
        csvFileWriter.writeToFile(REPORT);
    }
}
