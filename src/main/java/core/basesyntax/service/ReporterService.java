package core.basesyntax.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ReporterService {
    Map<String, BigDecimal> get(List<String> readFile);
}
