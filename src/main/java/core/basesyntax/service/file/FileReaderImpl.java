package core.basesyntax.service.file;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    @Override
    public String readFromFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String fruitInfo = bufferedReader.readLine();

            while (fruitInfo != null) {
                stringBuilder.append(fruitInfo)
                        .append(System.lineSeparator());
                fruitInfo = bufferedReader.readLine();
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path);
        }
    }
}
