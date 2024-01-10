package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitOperationStrategy;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {
    private static final String REPORT_FILE_PATH = ".\\src\\main\\resourse\\report.csv";

    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        FileWriterImpl fileWriter = new FileWriterImpl();
        DataParserImpl parserService = new DataParserImpl();
        FruitOperationStrategy strategy = new FruitOperationStrategy();
        ReportServiceImpl reportService = new ReportServiceImpl();

        List<String> readData = fileReader.read(".\\src\\main\\resourse\\fruits.csv");

        List<FruitTransaction> parsed = parserService.parse(readData);

        parsed.forEach(t -> strategy.getOperationService(t).processOperation(t));

        List<String> report = reportService.createReport();

        fileWriter.write(report, REPORT_FILE_PATH);
    }
}
