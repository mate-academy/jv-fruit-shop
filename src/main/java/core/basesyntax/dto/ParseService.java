package core.basesyntax.dto;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;

import java.util.List;
import java.util.Set;

public interface ParseService {
    List<FruitRecord> convertStringDataIntoFruitRecordList(String datInString);

    String convertStorageDataIntoWritableString(Set<Fruit> datInString);
}
