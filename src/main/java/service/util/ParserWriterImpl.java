package service.util;

import dao.StorageDao;
import java.util.List;
import java.util.stream.Collectors;

public class ParserWriterImpl implements ParserWriter {

    static final String JAVA_CODE = "=";
    static final String FILE_CODE = ",";
    private final StorageDao storageDao;

    public ParserWriterImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public List<String> parsedListToFile() {
        return storageDao.getAllFruits()
               .stream()
               .map(s -> s.replace(JAVA_CODE, FILE_CODE))
               .collect(Collectors.toList());
    }
}
