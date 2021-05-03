package shopservice;

import java.util.List;

public interface StoreService {
    String getReport();

    boolean addToStorage(List<String> dataFromFile);
}
