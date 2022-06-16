package core.basesyntax.dao;

import core.basesyntax.model.Model;
import java.util.List;
import java.util.Map;

public interface ActionsDao {
    List<Model> getAllActions();

    boolean isDoneReport(Map<String, Integer> modelAmount);
}
