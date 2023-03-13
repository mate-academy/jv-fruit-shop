package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationParser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.StorageCalculator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.OperationParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.StorageCalculatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final String REPORT_HEAD_LINE = "Fruit shop report: ";
    private static final ReaderService fileReaderService = new ReaderServiceImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final OperationParser operationParser = new OperationParserImpl();
    private static final WriterService fileWriterService = new WriterServiceImpl();
    private static final StorageCalculator storageCalculator = new StorageCalculatorImpl();

    public static void main(String[] args) {
        List<String> list = fileReaderService.read(INPUT_FILE_PATH);
        List<FruitTransaction> data = operationParser.parseOperation(list);
        storageCalculator.calculate(data);
        String report = reportGenerator.getReport();
        fileWriterService.write(report, OUTPUT_FILE_PATH);
        System.out.println(REPORT_HEAD_LINE + System.lineSeparator() + report);
    }
}
