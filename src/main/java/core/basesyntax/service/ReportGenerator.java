package core.basesyntax.service;

import java.util.HashMap;

public interface ReportGenerator {
    String create(HashMap<String, Integer> data);
}
