package core.basesyntax;

import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportFileWriter;
import core.basesyntax.service.impls.ReportCreatorImpl;
import core.basesyntax.service.impls.ReportFileWriterImpl;

public class Main {
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Application application = new Application();
        application.initialize();

        ReportFileWriter writer = new ReportFileWriterImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        writer.writeToFile(OUTPUT_FILE, reportCreator.getReport());
    }
}
