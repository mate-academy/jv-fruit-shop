package core.basesyntax.service.serviceimpl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.interfaces.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeDataToFile(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot save to file" + e.getMessage());
        }
    }
}
