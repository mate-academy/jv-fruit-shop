package core.basesyntax.writeToFileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeToFile(String fruitList, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(fruitList);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file ", e);
        }
    }
}
