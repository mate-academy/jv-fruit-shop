package core.basesyntax.db;

import core.basesyntax.exception.OutputWriteException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriterImpl implements OutputWriter {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void generateReport(String toWrite, String toFile) {
        File file = new File(toFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(FIRST_LINE + toWrite);
        } catch (IOException e) {
            throw new OutputWriteException("Can't write to file" + toWrite, e);
        }
    }
}
