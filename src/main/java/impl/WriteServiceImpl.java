package impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteService;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String report, String pathToFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile));
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
