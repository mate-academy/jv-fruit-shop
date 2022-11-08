package service.writereadcsv;

import java.util.List;

public interface FileReader {
    List<String> readFromFileCsv(String filePath);
}
