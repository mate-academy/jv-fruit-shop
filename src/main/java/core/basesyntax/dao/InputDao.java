package core.basesyntax.dao;

import java.util.List;

public interface InputDao {
    List<String> parse(String fileName);
}
