package core.basesyntax.service.export;

import core.basesyntax.ExportData;
import java.util.List;

public interface ExportService {

    List<ExportData> prepareData();
}
