package core.basesyntax.impl;

import core.basesyntax.service.TextFileWriterInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter implements TextFileWriterInterface {
    @Override
    public void writeText(String text, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        }
    }
}
