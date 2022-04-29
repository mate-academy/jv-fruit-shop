package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private StorageDao storageDao;

    public ReportServiceImpl() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public String report() {
        return "fruit,quantity\n" + storageDao.addAll().stream()
                .map(i -> i.getKey().getFruit()
                        + "," + i.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
