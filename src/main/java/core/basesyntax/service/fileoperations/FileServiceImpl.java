package core.basesyntax.service.fileoperations;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String INPUT_FILENAME = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "input.csv";
    private static final String OUTPUT_FILENAME = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "output.csv";

    @Override
    public List<String> readData() {
        List<String> dataList;
        try {
            dataList = Files.readAllLines(Path.of(INPUT_FILENAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + INPUT_FILENAME);
        }
        return dataList;
    }

    @Override
    public void writeData(String data) {
        try {
            Files.write(Path.of(OUTPUT_FILENAME), data.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + OUTPUT_FILENAME);
        }
    }
}
