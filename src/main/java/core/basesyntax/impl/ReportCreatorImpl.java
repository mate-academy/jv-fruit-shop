package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public List<String> createReport() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        ReportCreatorImpl::apply
                ));
    }

    private static List<String> apply(List<String> list) {
        list.add(0, "fruit,quantity");
        return list;
    }
}
