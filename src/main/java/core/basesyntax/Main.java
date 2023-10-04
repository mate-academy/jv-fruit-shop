package core.basesyntax;

import core.basesyntax.service.ParserService;
import core.basesyntax.service.ParserServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE = "src/main/resources/output.csv";
    public static final ReaderService READER_FILE = new ReaderServiceImpl();
    public static final ParserService PARSER_FILE = new ParserServiceImpl();
    public static final WriterService WRITER_FILE = new WriterServiceImpl();

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        List<String> contentFromFile = READER_FILE.readFromFile(INPUT_FILE);
        contentFromFile.remove(0);
        contentFromFile.stream()
                .map(PARSER_FILE::parseLine)
                .forEach(operationStrategy::performOperation);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        WRITER_FILE.writeToFile(OUTPUT_FILE, report);
    }
}
