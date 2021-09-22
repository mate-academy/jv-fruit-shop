package core.service.report;

import core.db.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String PATH_OUTPUT = "src/main/resources/report_output.csv";

    @Override
    public List<String> createReport() {
        List<String> result = new ArrayList<>();
        result.add(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.stockStorage.entrySet()) {
            result.add(entry.getKey() + "," + entry.getValue());
        }
        return result;
    }

    @Override
    public void writeReport(List<String> report, String filePath) {
        File file = new File(PATH_OUTPUT);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (String record : report) {
                bufferedWriter.write(record + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }

    }
}
