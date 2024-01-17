package core.basesyntax.service.impl;

import core.basesyntax.dao.CsvFileDaoImpl;
import core.basesyntax.dao.FileDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.UniqueFruitsAdderService;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileUniqueFruitsServiceAdder implements UniqueFruitsAdderService {
    private static final int REQUIRED_SIZE = 3;
    private static final int FRUIT_INDEX = 1;
    private static final String COMMA = ",";
    private static final String VALID_INPUT = "^[brsp],[a-zA-Z]+,[0-9]+$";
    private FileDao fileDao = new CsvFileDaoImpl();
    private Storage csvFileStorage;

    public CsvFileUniqueFruitsServiceAdder(Storage csvFileStorage) {
        this.csvFileStorage = csvFileStorage;
    }

    @Override
    public void add(List<String> readFile, Storage storage) {
        readFile = readFile
                .stream()
                .map(string -> {
                    String[] dividedByComme = string.split(COMMA);
                    if (dividedByComme.length != REQUIRED_SIZE
                            || !(string.matches(VALID_INPUT))) {
                        throw new IllegalArgumentException(
                                "the structure of file must match type,fruit,quantity");
                    }
                    return dividedByComme[FRUIT_INDEX];
                })
                .distinct()
                .collect(Collectors.toList());
        fileDao.addToStorage(readFile, csvFileStorage);
    }
}
