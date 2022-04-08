package core.basesyntax;

import core.basesyntax.service.StorageDao;
import java.util.List;

public interface ReportFormatter {
    public List<String> format(StorageDao report);
}
