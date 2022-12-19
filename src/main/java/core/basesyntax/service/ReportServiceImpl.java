package core.basesyntax.service;

import core.basesyntax.storage.StorageInformation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public void generateReport() {
        String filePath = "src" + File.separator + "main" + File.separator + "java"
                + File.separator + "core" + File.separator + "basesyntax"
                + File.separator + "files" + File.separator + "report.csv";
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append("fruit,quantity");
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> storage
                    : StorageInformation.getShopReport().entrySet()) {
                bufferedWriter.append(storage.getKey() + "," + storage.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
