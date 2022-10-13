package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReportCsvParser {  
    List<FruitTransaction> parse(List<String> data);
}
