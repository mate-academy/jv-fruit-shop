package core.basesyntax.service.operations;

import core.basesyntax.controller.StorageService;
import core.basesyntax.controller.StorageServiceImpl;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Product;
import java.util.List;

public interface Operation {
    StorageService<Product> storageService = new StorageServiceImpl(
            new StorageDaoImpl());

    boolean updateStorage(List<Product> product);
}
