package app.service.impl;

import app.db.Storage;
import app.service.FruitService;

public class FruitServiceImpl implements FruitService {
    private static final String SEPARATOR = ",";
    private static final String HEAD = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder reportText = new StringBuilder(HEAD);
        Storage.storage.forEach((key, value) -> reportText.append(System.lineSeparator())
                .append(key.getName())
                .append(SEPARATOR)
                .append(value));
        return reportText.toString();
    }
}
