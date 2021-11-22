package core.basesyntax;

import core.basesyntax.service.DataParser;
import core.basesyntax.service.ReportValidator;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import java.util.List;

public class Main {
    private static final String INPUT_DATA_FILE_PATH
            = "src/main/java/core/basesyntax/resources/daily_report.csv";
    private static final String REPORT_FILE_PATH
            = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        StorageService storageService = new StorageService();
        DataParser dataParser = new DataParser();
        List<String> inputData = new CsvReader().read(INPUT_DATA_FILE_PATH);
        new ReportValidator().test(inputData);
        storageService.updateStorage(dataParser.formatInputData(inputData));
        String data = dataParser.formatReport(storageService.getStorageStatistic());
        new CsvWriter().write(REPORT_FILE_PATH, data);
    }
}
