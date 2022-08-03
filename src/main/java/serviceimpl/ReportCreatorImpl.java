package serviceimpl;

import dao.StorageDao;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements service.ReportCreator {
    private static final String HEADER = "fruits, quantity";
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String create() {
        return HEADER + storageDao.getAll().entrySet()
                .stream()
                .map(e -> System.lineSeparator() + e.getKey()
                + "," + e.getValue())
                .collect(Collectors.joining());
    }
}
