package core.basesyntax.service;

import java.io.FileWriter;
import java.io.IOException;

public class RapportCreator {

    public void createRapport(String path, String content) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }

}
