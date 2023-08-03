package core.basesyntax.service;

import core.basesyntax.exceptions.FileException;
import core.basesyntax.interfaces.FileWriterTool;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterToolImpl implements FileWriterTool {

    @Override
    public void writeToFile(String data, String reportPath) {
        File file = new File(reportPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new FileException(
                    "An error occurred while creating a report file at the path "
                            + reportPath, e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileException("An error occurred while writing a report data ", e);
        }

    }
}
