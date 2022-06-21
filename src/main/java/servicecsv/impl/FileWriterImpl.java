package servicecsv.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import servicecsv.FileWriterService;

public class FileWriterImpl implements FileWriterService {
    @Override
    public void writeToFile(String pathName, List<String> data) {
        File file = new File(pathName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String string : data) {
                bufferedWriter.write(String.join(",", string));
                bufferedWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file correctly.", e);
        }
    }
}
