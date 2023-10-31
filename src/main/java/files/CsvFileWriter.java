package files;

import java.io.BufferedWriter;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    public static final String CANT_WRITE_DATA_INTO_THE_FILE_MESSAGE =
            "Can't write data into the file: ";

    @Override
    public void writeIntoFile(String path, String data) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(CANT_WRITE_DATA_INTO_THE_FILE_MESSAGE + path);
        }
    }
}
