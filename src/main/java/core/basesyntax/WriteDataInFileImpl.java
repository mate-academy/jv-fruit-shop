package core.basesyntax;

import core.basesyntax.service.WriteDataToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataInFileImpl implements WriteDataToFile {
    @Override
    public void writeDataToFile(ArrayList<String> data, String fileFrom) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFrom))) {
            for (int i = 0; i < data.size(); i++) {
                bufferedWriter.write(data.get(i));
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("File can not be written");
        }
    }
}
