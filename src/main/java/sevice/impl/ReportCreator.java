package sevice.impl;

import dao.StorageDao;
import java.util.List;
import service.ReportService;

public class ReportCreator implements ReportService {
    private StorageDao storageDao;

    public ReportCreator(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public List<String> createReport() {
        return storageDao.getAll();
    }
}
