package fileservice;

import errors.InvalidFileExtensionException;
import errors.WriteDataToFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriteFileServiceImpl implements WriteFileService {
    @Override
    public void write(String file, String content) {
        if (!file.endsWith(".csv")) {
            throw new InvalidFileExtensionException(
                    "Invalid file extension, extension must be 'csv'.");
        }
        File newFile = new File(file);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(content);
        } catch (FileNotFoundException e) {
            throw new WriteDataToFileException("Can't write data in file!" + file);
        }
    }
}
