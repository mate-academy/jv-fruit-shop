package core.basesyntax;

import core.basesyntax.dao.CsvReportHandler;
import core.basesyntax.dao.ReportHandler;
import core.basesyntax.service.DataFormatter;
import core.basesyntax.service.ReportValidator;
import core.basesyntax.service.StorageService;
import java.util.List;

public class Main {
    private static final String INPUT_DATA_FILE_PATH
            = "src/main/java/core/basesyntax/resources/daily_report.csv";
    private static final String REPORT_FILE_PATH
            = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        StorageService storageService = new StorageService();
        ReportValidator validator = new ReportValidator();
        DataFormatter dataFormatter = new DataFormatter(validator);
        ReportHandler reportHandler = new CsvReportHandler();

        List<String> inputData = reportHandler.read(INPUT_DATA_FILE_PATH);
        storageService.updateStorage(dataFormatter.formatInputData(inputData));

        String data = dataFormatter.formatReport(storageService.getStorageStatistic());
        reportHandler.write(REPORT_FILE_PATH, data);
    }
}
