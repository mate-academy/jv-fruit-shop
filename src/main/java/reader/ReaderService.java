package reader;

import java.util.List;
import model.FruitRecord;

public interface ReaderService {
    List<FruitRecord> read(String path);
}
