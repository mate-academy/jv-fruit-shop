package core.basesyntax.services;

import java.util.Map;

public interface ReportGenerator {
    String generate(Map<String, Integer> data);
}
