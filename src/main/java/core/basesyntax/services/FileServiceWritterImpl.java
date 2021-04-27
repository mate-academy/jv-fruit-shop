package core.basesyntax.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceWritterImpl implements FileServiceWritter {
    @Override
    public boolean write(String report, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write data to file" + toFile, e);
        }
        return true;
    }
}
