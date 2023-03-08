package core.basesyntax.service;

import java.util.List;

public interface ProcessDataFromOrder {
    List<String[]> split(List<String> order);
}
