package core.basesyntax.service.impl;

import core.basesyntax.service.WriterFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFileImpl implements WriterFile {

    @Override
    public void writeToFile(String content, String fileName) {
        try (FileWriter writer = new FileWriter(fileName);
                BufferedWriter bwr = new BufferedWriter(writer)) {
            bwr.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + fileName, e);
        }
    }
}
