package core.basesyntax.writedata;

import core.basesyntax.DataBase;
import core.basesyntax.clear.ClearDataFile;
import core.basesyntax.clear.ClearDataFileImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataWritingImpl implements DataWriting {
    private static final int TITLE = 0;
    private ClearDataFile clearDataFile;

    public void setClearDataFile(ClearDataFile clearDataFile) {
        this.clearDataFile = clearDataFile;
    }

    @Override
    public void writeData(String fileName) {
        setClearDataFile(new ClearDataFileImpl());
        String[] strings = new String[DataBase.fruitsAmount.size() + 1];
        strings[TITLE] = "fruit,quantity";
        int index = 1;
        for (Map.Entry<String, Integer> entry : DataBase.fruitsAmount.entrySet()) {
            strings[index] = entry.getKey() + "," + entry.getValue();
            index++;
        }
        clearDataFile.cleaningData(fileName);
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String data : strings) {
                writer.write(data + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file"
                    + fileName, e);
        }
    }
}
