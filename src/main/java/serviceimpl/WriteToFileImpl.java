package serviceimpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteToFile;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void write(String pathFile, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
            writer.write(toFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFile, e);
        }
    }
}
