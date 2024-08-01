package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIELDS_NAMES = "type,fruit,quantity\n";
    private final List<FruitTransaction> transactions;

    public ReportGeneratorImpl(List<FruitTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String generateReport() {
        String builder = Storage.fruits.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue() + "\n")
                .collect(Collectors.joining("", FIELDS_NAMES, ""));

        return builder;
    }
}
