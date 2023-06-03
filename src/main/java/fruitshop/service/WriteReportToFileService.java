package fruitshop.service;

import java.io.File;

public interface WriteReportToFileService {
    void writeReportToFile(String reportText, File toFile);
}
