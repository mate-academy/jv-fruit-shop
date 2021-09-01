package core.basesyntax.dao;

import core.basesyntax.exception.ValidationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteReportImpl implements WriteReport {
    private final String fileName;

    public WriteReportImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(List<String> report) {
        try {
            BufferedWriter writeToFile = new BufferedWriter(new FileWriter(new File(fileName)));
            for (String line : report) {
                try {
                    writeToFile.write(line);
                } catch (IOException e) {
                    throw new ValidationException("Can't write to file");
                }
            }
            writeToFile.close();
        } catch (IOException e) {
            throw new ValidationException("Can't found file");
        }
    }
}
