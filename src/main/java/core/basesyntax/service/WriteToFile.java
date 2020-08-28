package core.basesyntax.service;

import core.basesyntax.FinalString;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void print(String filePath) {
        FinalString finalString = new FinalString();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(finalString.getFinalString());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
