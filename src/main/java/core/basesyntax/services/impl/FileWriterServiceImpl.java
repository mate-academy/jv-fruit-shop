package core.basesyntax.services.impl;

import core.basesyntax.services.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void write(String report, File finalReportFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalReportFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file - " + finalReportFile, e);
        }
    }
}
