package file.writer;

import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterImpl implements FileWriter {
    private static final String START_PATH = "./";

    @Override
    public void write(String report, String fileName) {
        try (
                PrintWriter reportWriter = new PrintWriter(START_PATH + fileName)) {
            reportWriter.print(report);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
