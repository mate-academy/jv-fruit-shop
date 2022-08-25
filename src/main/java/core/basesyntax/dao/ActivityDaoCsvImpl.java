package core.basesyntax.dao;

import core.basesyntax.model.Activity;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.ActivityParse;
import core.basesyntax.service.ActivityParseImpl;
import core.basesyntax.service.strategy.data.CharToActivity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityDaoCsvImpl implements ActivityDao {
    private static final Map<String, TypeActivity> CHAR_TO_ACTIVITY = CharToActivity.getMap();
    private final ActivityParse activityParse;

    public ActivityDaoCsvImpl() {
        activityParse = new ActivityParseImpl();
    }

    @Override
    public List<Activity> getAll(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName)).stream()
                .filter(l -> l != null && CHAR_TO_ACTIVITY.get(l.substring(0,1)) != null)
                .map(activityParse::toActivity)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }
}
