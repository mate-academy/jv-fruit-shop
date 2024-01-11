package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.convertator.DataConvertor;
import core.basesyntax.service.convertator.DataConvertorImpl;

public class StorageServiceImpl implements StorageService {
    private final StorageDao storageDao;
    private final DataConvertor dataConvertor = new DataConvertorImpl();

    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void createNewFruitTransaction(String fruitTransaction) {
        for (String fruitInfo : fruitTransaction.split(System.lineSeparator())) {
            storageDao.add(dataConvertor.convertData(fruitInfo));
        }
    }

}
