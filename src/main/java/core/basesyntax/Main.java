package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.strategy.filestrategy.DataParser;
import core.basesyntax.strategy.filestrategy.DataParserHandler;
import core.basesyntax.strategy.filestrategy.ReportBuilder;
import core.basesyntax.strategy.filestrategy.ReportBuilderHandler;
import java.util.List;

public class Main {
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();
    private static final DataParserHandler dataParserHandler = new DataParserHandler();
    private static final ReportBuilderHandler reportBuilderHandler = new ReportBuilderHandler();
    private static DataParser dataParser;
    private static ReportBuilder reportBuilder;
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        dataParser = dataParserHandler.getDataParser("csv");
        reportBuilder = reportBuilderHandler.getReportBuilder("csv");
        String data = fileReaderService.readFromFile(INPUT_PATH);
        List<FruitTransaction> transactions = dataParser.parseData(data);
        String report = reportBuilder.buildReport(transactions);
        fileWriterService.writeToFile(OUTPUT_PATH, report);
    }
}
