package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DATA_SPLITTER = ",";
    private static final String REPORT_FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private final FruitRepository repository;

    public ReportGeneratorImpl(FruitRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generateReport() {
        return REPORT_FIRST_LINE
                + repository.getAll()
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + DATA_SPLITTER + entry.getValue())
                    .collect(Collectors.joining(System.lineSeparator()));
    }
}
