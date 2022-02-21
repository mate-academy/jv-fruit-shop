package core.basesyntax.sevice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public void writeDataToFile(String data, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file or write data to file!", e);
        }
    }
}


/*
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file!", e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file!", e);
        }
 */
