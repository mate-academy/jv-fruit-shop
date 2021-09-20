import java.util.List;
import java.util.Map;

public interface StorageService {
    Map<String, Integer> processingData(List<FruitRecord> fruitRecordList);
}
