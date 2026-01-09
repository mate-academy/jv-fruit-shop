package core.basesyntax;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader reader = new FileReaderImpl();
        List<String> lines =
                reader.read("src/main/resources/reportToRead.csv");

        OperationStrategy strategy = new OperationStrategyImpl();

        CsvProcessor processor = new CsvProcessor(strategy);
        Map<String, Integer> result = processor.process(lines);

        ReportGenerator generator = new ReportGeneratorImpl();
        String report = generator.getReport(result);

        FileWriter writer = new FileWriterImpl();
        writer.write(report, "src/main/resources/finalReport.csv");
    }
}
