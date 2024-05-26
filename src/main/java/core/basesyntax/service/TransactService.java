package core.basesyntax.service;

import java.util.HashMap;

public interface TransactService {
    HashMap<String, Integer> process(String[] data);
}
