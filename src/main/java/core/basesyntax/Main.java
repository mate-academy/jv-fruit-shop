package core.basesyntax;

import core.basesyntax.service.DailyReportWriter;
import core.basesyntax.service.DailyReportWriterImpl;

public class Main {
    public static void main(String[] args) {
        DailyReportWriter reportWriter = new DailyReportWriterImpl();
        reportWriter.write();
    }
}
