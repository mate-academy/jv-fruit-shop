package core.basesyntax.service.operations;

import core.basesyntax.controller.StorageService;
import core.basesyntax.controller.StorageServiceImpl;
import core.basesyntax.model.Product;
import java.util.List;

public interface Operation {
    StorageService<Product> STORAGE_SERVICE = new StorageServiceImpl();

    boolean updateStorage(List<Product> product);
}
