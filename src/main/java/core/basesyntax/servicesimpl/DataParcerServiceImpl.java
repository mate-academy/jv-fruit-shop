package core.basesyntax.servicesimpl;

import core.basesyntax.services.DataParcerService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParcerServiceImpl implements DataParcerService {
    public static final String VALUE_SEPARATOR = ",";
    public static final int ROW_TITLE_INDEX = 1;

    @Override
    public List<String[]> parceDataFromCsv(List<String> nonParcedData) {
        return nonParcedData.stream()
                .skip(ROW_TITLE_INDEX)
                .map(s -> s.split(VALUE_SEPARATOR))
                .collect(Collectors.toList());
    }
}
