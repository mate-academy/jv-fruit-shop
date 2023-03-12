package service.impl;

import service.DataProcessing;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessingImpl implements DataProcessing {
    public static final String DATA_SPLITTER = ",";
    @Override
    public List<String[]> data(List<String> order) {
        return order.stream()
                .map(info -> info.split(DATA_SPLITTER))
                .collect(Collectors.toList());
    }
}
