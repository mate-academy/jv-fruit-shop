package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String WORDS_SEPARATOR = ",";
    private static final String NEW_LINE = "\n";
    private static final String HEAD_OF_FILE = "fruit,quantity\n";
    private static final String PATH_TO_SAVE = "src/main/java/resources/report_file.csv";

    private List<String> getLinesList(Map<String, Integer> reportList) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> linesList = new ArrayList<>();
        stringBuilder.append(HEAD_OF_FILE);
        for (Map.Entry<String, Integer> entry : reportList.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        linesList.add(stringBuilder.toString());
        return linesList;
    }

    @Override
    public void writeReportToFile(Map<String, Integer> reportList) {
        List<String> linesList = getLinesList(reportList);
        File reportFile = new File(PATH_TO_SAVE);
        for (String line : linesList) {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(reportFile, true))) {
                writer.write(line);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file " + reportFile, e);
            }
        }
    }
}
