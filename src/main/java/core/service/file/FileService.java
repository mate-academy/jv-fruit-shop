package core.service.file;

import java.io.IOException;
import java.util.List;

public interface FileService {
    String PATH_INPUT = "src/main/resources/report_input.csv";

    List<String> readFile(String filePath) throws IOException;
}
