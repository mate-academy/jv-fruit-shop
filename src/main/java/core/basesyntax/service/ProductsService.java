package core.basesyntax.service;

import java.util.List;

public interface ProductsService {
    void addToStorage(List<String> dataFromFile);

    List<String> getFromStorage();
}
