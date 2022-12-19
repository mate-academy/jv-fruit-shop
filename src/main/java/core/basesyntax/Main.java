package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.strategy.DataFileHandler;
import core.basesyntax.strategy.DataParser;
import core.basesyntax.strategy.ReportBuilder;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final DataFileHandler dataFileHandler = new DataFileHandler();
    private static DataParser dataParser;
    private static ReportBuilder reportBuilder;
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        dataParser = dataFileHandler.getDataParser("csv");
        reportBuilder = dataFileHandler.getReportBuilder("csv");
        String data = fileReaderService.readFromFile(Path.of(INPUT_PATH));
        List<FruitTransaction> transactions = dataParser.parseData(data);
        String report = reportBuilder.buildReport(transactions);
        fileWriterService.writeToFile(Path.of(OUTPUT_PATH), report);
    }
}
