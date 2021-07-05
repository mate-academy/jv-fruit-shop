package app.service;

import static app.constants.Constants.SEPARATOR;

import app.db.Storage;

public class FruitServiceImpl implements FruitService {
    public static final String HEAD = "fruit,quantity";

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
