package core.basesyntax.service;

import java.util.List;

public interface ProductService {
    void addToStorage(List<String> dataFromFile);

    List<String> getFromStorage();
}
