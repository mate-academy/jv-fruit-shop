package core.basesyntax.service;

import core.basesyntax.service.activity.Activity;
import java.util.List;

public interface RecordParser {
    List<Activity> parseRecords(List<String> records);
}
