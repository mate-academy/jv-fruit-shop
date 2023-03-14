package core.basesyntax.services;

import java.util.List;

public interface DataParcerService {
    List<String[]> parceDataFromCsv(List<String> nonParcedData);
}
