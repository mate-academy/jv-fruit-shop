package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class ReportToCsvService implements ReportService {
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";
    private static final String HEAD_LINE = "fruit,quantity";
    private static final String REGEX = ",";

    @Override
    public void generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD_LINE);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(REGEX)
                    .append(entry.getValue());
        }
        FileService fileWriter = new FileServiceImpl();
        fileWriter.write(OUTPUT_FILE_NAME, stringBuilder.toString());
    }
}
