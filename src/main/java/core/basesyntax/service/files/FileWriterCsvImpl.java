package core.basesyntax.service.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCsvImpl implements FileWriterCsv{
    @Override
    public void write(String data, String filePath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file", e);
        }
    }
}
