package fruitshop.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String output, String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create the file " + filePath, e);
        }
        try {
            Files.write(file.toPath(), output.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file" + filePath, e);
        }
    }
}
