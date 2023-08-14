package core.basesyntax.model;

import java.util.List;

public interface RecordsMapper {
    List<Record> map(String sourceFilename);
}
