package core.service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class OsFileServiceImpl implements FileService {
    private static final String PATH_INPUT = "src/main/resources/report_input.csv";

    public OsFileServiceImpl() {
    }

    @Override
    public List<String> readFile(String filePath) {
        filePath = PATH_INPUT;
        try {
            List<String> records = Files.readAllLines(new File(filePath).toPath());
            records.remove(0);
            return records;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
    }
}

