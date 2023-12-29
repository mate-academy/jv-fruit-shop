package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeDataToFile(Path path, String str) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            bufferedWriter.write(str);
        } catch (IOException e) {
            System.out.println("there's something gone wrong" + e);
        }
    }
}
