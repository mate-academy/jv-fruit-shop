package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterService implements FileWriterService {

    @Override
    public void writeReport(File outputFile, List<String> strings) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            bufferedWriter.write("fruit,quantity");
            for (String string : strings) {
                bufferedWriter.write(System.lineSeparator() + string);
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem to write to file " + outputFile, e);
        }
    }
}
