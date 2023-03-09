package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface ReaderService {
    List<String> readFileToList(File inputFile);
}
