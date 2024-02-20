package core.basesyntax.service;

import java.io.File;

public interface ShopService {
    String readAndConvert(String fromFileName);

    void processData(String inputData);

    String createReport(String fromFileName);

    File writeReportToFile(String outputPath);
}
