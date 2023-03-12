package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.StorageCalculator;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.StorageCalculatorImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final OperationParser operationParser = new OperationParserImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final StorageCalculator storageCalculator = new StorageCalculatorImpl();

    public static void main(String[] args) {
        List<String> list = fileReaderService.fileRead(INPUT_FILE_PATH);
        List<FruitTransaction> data = operationParser.parseOperation(list);
        storageCalculator.calculate(data);
        String report = reportGenerator.getReport();
        fileWriterService.fileWrite(report, OUTPUT_FILE_PATH);
        System.out.println(report);
    }
}
