package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.util.List;

public interface ReportService {
    List<String> makeReport(StorageDao storage);
}
