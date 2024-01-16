package core.basesyntax.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

public interface WriterService {
    void write(File toFileName, Map<String, BigDecimal> map);
}
