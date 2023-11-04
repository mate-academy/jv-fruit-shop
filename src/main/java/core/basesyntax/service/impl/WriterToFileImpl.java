package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeToFile(String output, String toFileName) {
        File file = new File(toFileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(output);
        } catch (IOException e) {
            throw new RuntimeException("can't write to  file" + toFileName, e);
        }
    }
}
