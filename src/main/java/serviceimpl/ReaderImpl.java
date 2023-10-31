package serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.Reader;

public class ReaderImpl implements Reader {
    private static final String FILE_FINDING_PROBLEM = "Can not find file ";

    public List<String> readDataFromFile(String filePath) {
        try {
            List<String> dataFromFile = Files.readAllLines(Path.of(filePath));
            if (!dataFromFile.isEmpty()) {
                dataFromFile.remove(0);
            }
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException(FILE_FINDING_PROBLEM + filePath, e);
        }
    }
}
