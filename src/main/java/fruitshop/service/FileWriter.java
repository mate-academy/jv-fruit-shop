package fruitshop.service;

import java.io.File;

public interface FileWriter {
    void writeReportToFile(String reportText, File toFile);
}
