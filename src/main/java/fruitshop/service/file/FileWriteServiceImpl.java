package fruitshop.service.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriteService {

    /* replace to NIO */
    @Override
    public void writeDataToFile(String data, String filePath) {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + e);
        }
    }
}
