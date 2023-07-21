package core.basesyntax.service;

import java.util.List;

public interface ReportCreatorService<T> {
    String create(List<T> info);
}
