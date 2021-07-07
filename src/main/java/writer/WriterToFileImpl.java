package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFileImpl implements Writer<File, String> {
    @Override
    public void write(File writeTo, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeTo))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: ", e);
        }
    }
}
