package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void writeDataToFile(String fileName, String destinationFileName) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(destinationFileName))) {
            bufferedWriter.write(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + destinationFileName, e);
        }
    }
}
