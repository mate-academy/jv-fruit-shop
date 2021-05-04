package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportService {

    public static void buildReport(String filePath, StorageService storage) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Map.Entry<String, Integer> entry : storage.getStorageMap().entrySet()) {
                writer.write(String.valueOf(entry).replace('=', ','));
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file at " + filePath, e);
        }
    }
}
