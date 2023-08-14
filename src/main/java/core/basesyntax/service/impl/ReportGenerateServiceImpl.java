package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerateService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerateServiceImpl implements ReportGenerateService {
    private static final String HEADER_REPORT = "fruit,quantity";
    private final FruitStorage fruitStorage;

    public ReportGenerateServiceImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> mapFruits = fruitStorage.getMap();
        String result;
        result = HEADER_REPORT + System.lineSeparator()
                + mapFruits.entrySet()
                .stream().map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return result;
    }
}
