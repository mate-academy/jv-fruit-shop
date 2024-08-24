package file.reader;

import java.util.List;

public interface FileReader {
    List<String> readFromCsv(String fileName);
}
