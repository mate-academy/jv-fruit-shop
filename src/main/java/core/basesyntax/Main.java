package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.service.parsing.FileParserImpl;
import core.basesyntax.service.parsing.ReadFileImpl;
import core.basesyntax.service.repot.ReportFileCreationImpl;
import core.basesyntax.service.repot.ReportGenerationImpl;
import java.util.List;

public class Main {
    private static final String RECORDS_FILE_NAME = "src/main/assets/records.csv";
    private static final String REPORT_FILE_NAME = "src/main/assets/report.csv";

    public static void main(String[] args) {

        Storage storage = new StorageImpl();
        List<String> recordsFromFile = new ReadFileImpl().read(RECORDS_FILE_NAME);
        storage.set(new FileParserImpl().parse(recordsFromFile));

        String report = new ReportGenerationImpl().report(storage);
        new ReportFileCreationImpl().createReportFile(report, REPORT_FILE_NAME);
    }
}
