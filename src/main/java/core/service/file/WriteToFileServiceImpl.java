package core.service.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileServiceImpl implements WriteToFileService {
    private static final String PATH_OUTPUT = "src/main/resources/report_output.csv";

    @Override
    public void writeReport(List<String> report, String pathTo) {
        pathTo = PATH_OUTPUT;
        File file = new File(pathTo);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String record : report) {
                bufferedWriter.append(record).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file" + PATH_OUTPUT, e);
        }
    }
}
