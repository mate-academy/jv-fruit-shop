package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitOperationStrategy;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {
    private static final String REPORT_FILE_NAME = "src/main/resource/report.csv";
    private static final String READ_FILE_NAME = "src/main/resource/fruits.csv";

    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        FileWriterImpl fileWriter = new FileWriterImpl();
        DataParserImpl parserService = new DataParserImpl();
        FruitOperationStrategy strategy = new FruitOperationStrategy();
        ReportServiceImpl reportService = new ReportServiceImpl();

        List<String> readData = fileReader.read(READ_FILE_NAME);

        List<FruitTransaction> transactions = parserService.parse(readData);

        transactions.forEach(t -> strategy.getOperationService(t).processOperation(t));

        List<String> report = reportService.createReport();

        fileWriter.write(report, REPORT_FILE_NAME);
    }
}
