package core.basesyntax.interfaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public void write(String filePath, List<String> report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : report) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("There is a problem with a file!", e);
        }
    }
}
