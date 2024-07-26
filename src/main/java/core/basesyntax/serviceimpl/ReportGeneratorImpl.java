package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public Set<String> getReport() {
        Map<String, Integer> fruitStorage = Storage.fruitStorage;
        return fruitStorage.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toSet());
    }
}
