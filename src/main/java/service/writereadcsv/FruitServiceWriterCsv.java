package service.writereadcsv;

import java.util.List;
import model.FruitTransaction;

public interface FruitServiceWriterCsv {

    void writeToFileCsv(List<FruitTransaction> list, String fileToPath);
}
