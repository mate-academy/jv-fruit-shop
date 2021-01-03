package core.basesyntax.service;

import core.basesyntax.model.Plant;
import java.util.List;

public interface Report<T extends Plant> {
    String createReport(List<T> plants);
}
