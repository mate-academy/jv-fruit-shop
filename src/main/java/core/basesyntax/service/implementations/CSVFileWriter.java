package core.basesyntax.service.implementations;

import core.basesyntax.service.FileWriter;

import java.io.BufferedWriter;
import java.io.IOException;

public class CSVFileWriter implements FileWriter {

    @Override
    public void write(String report, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.write(report);
        } catch (IOException e) {
            System.out.println("Can't create file");
        }
    }
}
