package services;

import java.util.HashMap;
import java.util.Map;
import model.Position;
import model.Storage;

public class ReportService {
    private static final String HEADER_FOR_REPORT = "PRODUCT, QUANTITY, SHELF LIFE \n";
    private static final String FILE_PATH_TO_WRITE_RESULT = "src/test/java/results/result.txt";

    public void printReportIntoFile() {
        String content = getStorageContent();
        FileService fileService = new FileService();
        fileService.writeFile(content, FILE_PATH_TO_WRITE_RESULT);
    }

    private String getStorageContent() {
        StringBuilder content = new StringBuilder(HEADER_FOR_REPORT);
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Position> entry : Storage.storage.entrySet()) {
            if (result.containsKey(entry.getKey())) {
                result.put(entry.getKey(),
                        result.get(entry.getKey()) + entry.getValue().getQuantity());
                appendInfo(entry, content);
                continue;
            }
            result.put(entry.getKey(), entry.getValue().getQuantity());
            appendInfo(entry, content);
        }
        return content.toString();
    }

    private StringBuilder appendInfo(Map.Entry<String, Position> entry, StringBuilder content) {
        content.append(entry.getKey())
                .append(", ")
                .append(entry.getValue().getQuantity())
                .append(", ")
                .append(entry.getValue().getDate())
                .append("\n");
        return content;
    }
}
