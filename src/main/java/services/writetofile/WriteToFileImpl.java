package services.writetofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileImpl implements WriteToFile {
    private String filePath = "src/main/java/resources/report.csv";

    @Override
    public void writeToFile(List<String> report) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String stringReport : report) {
                bufferedWriter.write(stringReport + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new WriterException("Can't write to file", e);
        }

    }
}
