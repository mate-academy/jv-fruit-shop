package core.basesyntax.readFileService;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ReaderService {
    List<FruitTransaction> readFile(String inputFileName);
}
