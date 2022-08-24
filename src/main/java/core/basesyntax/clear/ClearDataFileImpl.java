package core.basesyntax.clear;

import core.basesyntax.DataBase;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClearDataFileImpl implements ClearDataFile {
    @Override
    public void cleaningData() {
        try {
            FileWriter writer = new FileWriter(DataBase.FILE_NAME);
            BufferedWriter buffWriter = new BufferedWriter(writer);
            buffWriter.write("");
            buffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't clear data from file: "
                    + DataBase.FILE_NAME, e);
        }
    }
}
