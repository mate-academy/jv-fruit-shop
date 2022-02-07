package core.basesyntax.service;

import core.basesyntax.model.DailyActivity;
import java.util.List;

public interface Parser {
    List<DailyActivity> parse(List<String> list);
}
