package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DbHandler;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserDataService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.DbHandlerImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserDataServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/database.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> read = fileReaderService.read(Path.of(INPUT_FILE_NAME));
        ParserDataService parserDataService = new ParserDataServiceImpl();
        List<FruitTransaction> parsedData = parserDataService.parse(read);
        DbHandler dbHandler = new DbHandlerImpl();
        dbHandler.proceed(parsedData);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        List<String> report = reportGeneratorService.report();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(Path.of(REPORT_FILE_NAME), report);
    }
}
