package file.writer;

import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterImpl implements FileWriter {
    private static final String START_PATH = "./src/main/resources/";
    private static final String FILE_FORMAT = ".csv";

    @Override
    public void writeToCsv(String report, String fileName) {
        if (!fileName.endsWith(FILE_FORMAT)) {
            throw new RuntimeException("File " + fileName + " should be .csv");
        }

        try (
                PrintWriter reportWriter = new PrintWriter(START_PATH + fileName)) {
            reportWriter.print(report);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
