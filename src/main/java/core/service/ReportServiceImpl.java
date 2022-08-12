package core.service;

import core.storage.Storage;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String CHAR_FOR_SPLIT = ",";

    private Storage storage;

    public ReportServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String create() {
        return storage.getAllData()
            .entrySet()
            .stream()
            .map(stringIntegerEntry -> stringIntegerEntry.getKey() + CHAR_FOR_SPLIT
                    + stringIntegerEntry.getValue())
            .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}
