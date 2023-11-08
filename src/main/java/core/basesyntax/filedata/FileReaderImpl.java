package core.basesyntax.filedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    @Override
    public String[] readFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new java.io.FileReader(file))) {
            String fromText = bufferedReader.readLine();
            while (fromText != null) {
                stringBuilder.append(fromText).append(System.lineSeparator());
                fromText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + file, e);
        }
        return stringBuilder.toString().split(System.lineSeparator());
    }
}
