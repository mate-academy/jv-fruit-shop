package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.service.OperationParser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculatorServiceImpl;
import core.basesyntax.service.impl.OperationParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService fileReaderService = new ReaderServiceImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        OperationParser operationParser = new OperationParserImpl();
        WriterService fileWriterService = new WriterServiceImpl();
        CalculatorService storageCalculator = new CalculatorServiceImpl();
        List<String> list = fileReaderService.read(INPUT_FILE_PATH);
        List<FruitTransaction> data = operationParser.parseOperation(list);
        storageCalculator.calculate(data);
        String report = reportGenerator.getReport();
        fileWriterService.write(report, OUTPUT_FILE_PATH);
        System.out.println("Fruit shop report: " + System.lineSeparator() + report);
    }
}
