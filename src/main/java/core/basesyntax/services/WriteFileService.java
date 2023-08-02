package core.basesyntax.services;

import core.basesyntax.dao.StoreDao;

public interface WriteFileService {
    boolean writeToFile(StoreDao dao, String fileName);
}
