package servicecsv;

import java.util.List;

public interface FileReaderService {
    List<String[]> readTheFruitsStorage(String filePath);
}
