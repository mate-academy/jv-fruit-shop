package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDataToFileCsvImpl implements WriteDataToFile {
    private static final String FIRST_LINE = "fruit,quantity";

    public void writeListToCsvFile(List<String> listReport, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(FIRST_LINE + System.lineSeparator());
            for (String string : listReport) {
                bufferedWriter.write(string + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
