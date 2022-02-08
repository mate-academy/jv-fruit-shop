package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WriterServiceImp implements WriterService {
    private static final String FILE_REPORT_PATH = "src/main/resources/";
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH_mm_ss");

    @Override
    public void writeToFile(List<String> reportList) {
        String reportDateTime = dtf.format(LocalDateTime.now());

        String fullFilePath = FILE_REPORT_PATH + "report dated" + reportDateTime + ".csv";
        File file = new File(fullFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String line:
                    reportList) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create the file!", e);
        }
    }
}
