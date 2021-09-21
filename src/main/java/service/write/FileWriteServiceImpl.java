package service.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriteService {

    @Override
    public void fileWriter(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file" + filePath);
        }
    }
}
