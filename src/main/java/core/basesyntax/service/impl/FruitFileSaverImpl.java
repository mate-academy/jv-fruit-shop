package core.basesyntax.service.impl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.interfaces.FruitFileSaver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFileSaverImpl implements FruitFileSaver {
    @Override
    public void saveToFile(String report, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot save to file" + e.getMessage());
        }
    }
}
