package core.basesyntax.service.impl;

import core.basesyntax.service.ExportDataService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportDataServiceImpl implements ExportDataService {
    @Override
    public void writeToCsvFile(String inputReport, String destinationPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationPath))) {
            bufferedWriter.write(inputReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + destinationPath);
        }
    }
}
