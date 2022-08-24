package core.basesyntax.clear;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClearDataFileImpl implements ClearDataFile {
    @Override
    public void cleaningData(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter buffWriter = new BufferedWriter(writer);
            buffWriter.write("");
            buffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't clear data from file: "
                    + fileName, e);
        }
    }
}
