package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    @Override
    public String readFromFile(String fromFileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from " + fromFileName, e);
        }
        return builder.toString();
    }

    @Override
    public void writeToFile(String toFileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + toFileName, e);
        }
    }
}
