package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeToFile(String toWriteFile, String toWriteData) {
        File fileToWrite = new File(toWriteFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, false));
            writer.write(toWriteData);
            writer.close();
        } catch (IOException exc) {
            throw new RuntimeException("Can't write to file:" + fileToWrite, exc);
        }
    }
}
