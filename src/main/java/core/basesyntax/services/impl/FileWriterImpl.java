package core.basesyntax.services.impl;

import core.basesyntax.services.interfaces.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public boolean write(String dataToWrite, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create new file " + fileName);
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(dataToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + fileName);
        }
        return true;
    }
}
