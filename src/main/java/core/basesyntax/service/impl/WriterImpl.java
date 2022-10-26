package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private static final String OUTPUT_EXAMPLE_CSV = "outputFileExample.csv";

    @Override
    public void writeToFile(String report) {
        File file = new File("src/main/java/resources/outputFileExample.csv");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a new file " + OUTPUT_EXAMPLE_CSV, e);
        }
    }
}
