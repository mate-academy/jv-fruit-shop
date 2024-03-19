package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    private static final String READ_EXCEPTION_MESSAGE = "Can't read from file ";
    private static final String WRITE_EXCEPTION_MESSAGE = "Can't write to file ";

    @Override
    public String readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder builder = new StringBuilder();
            int read = reader.read();
            while (read != -1) {
                builder.append((char) read);
                read = reader.read();
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + filePath, e);
        }
    }

    @Override
    public void writeToFile(String path, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION_MESSAGE + path);
        }
    }
}
