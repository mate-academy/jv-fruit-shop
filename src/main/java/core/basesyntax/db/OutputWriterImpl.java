package core.basesyntax.db;

import core.basesyntax.exception.OutputWriteException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriterImpl implements OutputWriter {
    @Override
    public void generateReport(String toWrite, String toFile) {
        if (toWrite == null || toFile == null) {
            throw new OutputWriteException("You shouldn't pass null for function");
        }
        File file = new File(toFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(toWrite);
        } catch (IOException e) {
            throw new OutputWriteException("Can't write to file" + toWrite, e);
        }
    }
}
