package core.basesyntax.service.impl;

import core.basesyntax.service.DataProcessorService;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final String SEPARATOR = ",";

    @Override
    public List<String[]> processData(List<String> data) {
        return data.stream()
                .map(i -> i.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
