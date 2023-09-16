package fruitshop.service.serviceimpl;

import fruitshop.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void writeDataToTheFile(String fileName, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file: " + fileName, e);
        }
    }
}
