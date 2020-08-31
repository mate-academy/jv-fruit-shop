package core.basesyntax.write;

import java.io.IOException;

public class WriteFile implements FileWriter {
    private static final String HEAD_OF_FILE = "fruit, quantity\n";

    public void writingToFile(String path, String totalFruit) {
        try (java.io.FileWriter writer = new java.io.FileWriter(path, false)) {
            String text = HEAD_OF_FILE + totalFruit;
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("No such file", e);
        }
    }
}
