package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFileDaoWriterImpl implements FruitFileDaoWriter {
    @Override
    public void write(String report, String fileNameTo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameTo))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            System.err.println("Cannot write to file: " + fileNameTo
                    + ". Error: " + e.getMessage());
            throw new RuntimeException("Can't write to file " + fileNameTo, e);
        }
    }
}
