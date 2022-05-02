package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.OutputService;

public class OutputServiceImpl implements OutputService {
    private static final String FORMAT = "fruit,quantity";

    @Override
    public String getOutput() {
        return FORMAT + System.lineSeparator() + Storage.storage.keySet().stream()
                .map(key -> key + "," + Storage.storage.get(key))
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
