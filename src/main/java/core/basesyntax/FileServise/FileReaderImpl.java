package core.basesyntax.FileServise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader{
    @Override
    public List<String> readFile(String nameOfFile) {
        File file = new File(nameOfFile);
        List<String> dataOfFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                dataOfFile.add(value);
                value = bufferedReader.readLine();
            }
            bufferedReader.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataOfFile;
    }
}
