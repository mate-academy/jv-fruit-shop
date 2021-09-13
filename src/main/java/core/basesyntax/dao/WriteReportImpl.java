package core.basesyntax.dao;

import core.basesyntax.exception.ValidationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements WriteReport {

    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writeToFile = new BufferedWriter(new FileWriter(fileName))) {
            writeToFile.write(report);
        } catch (IOException e) {
            throw new ValidationException("Can't write to file");
        }
    }
}
