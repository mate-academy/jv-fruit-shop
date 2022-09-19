package service.writereadcsv;

import java.util.List;

public interface FruitServiceReaderCsv {
    List<String> readFromFileCsv(String filePath);
}
