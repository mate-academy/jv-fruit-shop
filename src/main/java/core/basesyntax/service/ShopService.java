package core.basesyntax.service;

import java.io.File;

public interface ShopService {
    String readAndConvert(File fromFile);

    void processData(String inputData);

    File createReport(File fromFileName);

    File writeReportToFile(File blankDestinationFile);
}
