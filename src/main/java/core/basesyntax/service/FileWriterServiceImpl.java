package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private String filePath;

    public FileWriterServiceImpl(String filePath) {
        this.filePath = filePath.equals("") ? "src\\defaultResult.csv" : filePath;
    }

    @Override
    public void writeToFile(String report) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close the file", e);
                }
            }
        }
    }
}
