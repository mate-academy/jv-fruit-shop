package core.basesyntax.filework;

import core.basesyntax.exceptions.ReadFromFileException;
import java.io.BufferedReader;
import java.io.IOException;

public class CsvFileReaderImpl implements FileReader {
    private static final String SEPARATOR = System.lineSeparator();

    public String[] read(String path) {
        String line;
        StringBuilder linesStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            while (true) {
                if ((line = br.readLine()) == null) {
                    break;
                }
                linesStringBuilder.append(line).append(SEPARATOR);
            }
        } catch (IOException e) {
            throw new ReadFromFileException("Can't read from file");
        }
        return linesStringBuilder.toString().split(SEPARATOR);
    }
}
