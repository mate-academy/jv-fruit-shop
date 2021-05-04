package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportFileWriter;
import core.basesyntax.service.impls.ReportFileWriterImpl;

public class Main {
    private static final String OUTPUT_FILE = "report.csv";

    public static void main(String[] args) {
        Application application = new Application();
        application.initialize();

        ReportFileWriter writer = new ReportFileWriterImpl();
        writer.writeToFile(OUTPUT_FILE);
    }
}
