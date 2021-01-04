package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorker {
    public void createFile(String fileName) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
        } catch (IOException x) {
            //TODO exception
            System.err.format("Can't create file name %s. %s", fileName, x);
        }
    }

    public void fillFile(String text, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for (byte temp : text.getBytes()) {
                writer.write(temp);
            }

        } catch (IOException e) {
            System.err.format("Can't write in file name %s. %s", path, e);
        }
    }
}
