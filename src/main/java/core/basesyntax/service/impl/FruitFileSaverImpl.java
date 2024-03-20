package core.basesyntax.service.impl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.interfaces.FruitFileSaver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFileSaverImpl implements FruitFileSaver {
    private CheckFilePathImpl filePathExist = new CheckFilePathImpl();

    @Override
    public void saveToFile(String report, String filePath) {
        if (filePathExist.checkFilePath(filePath)) {
            throw new NoFileToReadException("File path is invalid cannot read data");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot save to file" + e.getMessage());
        }
    }
}
