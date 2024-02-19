package core.basesyntax.service;

import java.io.File;

public interface ShopService {
    public String readAndConvert(String fromFileName);

    public void processData(String inputData);

    public String createReport(String fromFileName);

    public File writeReport(String outputPath);
}
