package core.basesyntax.workwithfile.filereader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;

    @Override
    public List<String[]> readFromFile(File file) {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            for (String datum : Files.readAllLines(file.toPath())) {
                data.add(datum.split(SEPARATOR));
            }
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot read data from file: " + file, ioException);
        }
        data.remove(HEADER_INDEX);
        return data;
    }
}
