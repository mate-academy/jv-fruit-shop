package fruitshop.service;

import java.io.File;
import java.util.Map;

public interface WriteReportToFile {
    void writeReportToFile(Map<String, Integer> reportText, File toFile);
}
