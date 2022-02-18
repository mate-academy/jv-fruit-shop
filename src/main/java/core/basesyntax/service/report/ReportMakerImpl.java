package core.basesyntax.service.report;

import core.basesyntax.service.file.FIleWriterService;
import java.io.File;

public class ReportMakerImpl implements ReportMaker {
    private static final File resultFile = new File("result.csv");
    private static final String REPORT_TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void makeReport(String data) {
        data = REPORT_TITLE + data;
        FIleWriterService.writeToFile(resultFile, data);
    }
}
