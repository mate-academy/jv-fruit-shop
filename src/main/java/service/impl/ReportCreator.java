package service.impl;

import dao.FruitStorageDao;
import java.util.List;
import service.CreatReport;

public class ReportCreator implements CreatReport {
    private final FruitStorageDao storageDao;

    public ReportCreator(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public List<String> creatReport() {
        return storageDao.getAll();
    }
}
