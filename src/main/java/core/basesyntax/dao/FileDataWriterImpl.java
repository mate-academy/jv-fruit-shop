package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileDataWriterImpl implements FileDataWriter {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final String newPath;

    public FileDataWriterImpl(String newPath) {
        this.newPath = newPath;
    }

    @Override
    public File writeData(List<String> processedList) {
        File file = new File(newPath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(REPORT_HEADER);
            bufferedWriter.newLine();
            for (String string : processedList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to a file" + file.getName(), e);
        }
        return file;
    }
}
