package core.basesyntax.service;

import core.basesyntax.record.Record;
import java.util.List;

public interface DataConverter {
    List<Record> convert(List<String> data);
}
