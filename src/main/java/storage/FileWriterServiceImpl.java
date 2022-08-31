package storage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/output.csv";
    private static final String FIRST_DOC_ROW = "fruit,quantity";

    @Override
    public File writeToFile(List<String> fruitDataToWrite) {
        List<String> toWrite = new ArrayList<>();
        toWrite.add(FIRST_DOC_ROW);
        toWrite.addAll(fruitDataToWrite);
        File file = new File(PATH_TO_OUTPUT_FILE);
        Path path = file.toPath();
        try {
            Files.write(path, toWrite);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Can't write to file %s", file), ex);
        }
        return file;
    }
}
