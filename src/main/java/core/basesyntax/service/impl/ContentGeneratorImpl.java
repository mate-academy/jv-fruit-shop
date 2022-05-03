package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.models.Fruit;
import core.basesyntax.service.ContentGenerator;
import java.util.Map;

public class ContentGeneratorImpl implements ContentGenerator {
    private static final String HEADER = "fruit,quantity";
    private StorageDao storage;

    public ContentGeneratorImpl(StorageDao storageDao) {
        this.storage = storageDao;
    }

    @Override
    public String generateContent() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry: storage.getAll()) {
            stringBuilder.append(entry.getKey().getFruitName()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
