package core.basesyntax.service;

import java.util.Map;

public interface IReportCreator {
    String create(Map<String, Integer> nameQuantityMap);
}
