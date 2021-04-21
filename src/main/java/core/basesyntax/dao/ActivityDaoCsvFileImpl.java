package core.basesyntax.dao;

import core.basesyntax.model.Activity;
import core.basesyntax.util.Util;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityDaoCsvFileImpl implements ActivityDao {
    private static final long TITLE_LINE = 1;
    private final String inputFile;

    public ActivityDaoCsvFileImpl(String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public List<Activity> getAll() {
        List<String> strings = Util.readFile(inputFile);
        return strings.stream()
                .skip(TITLE_LINE)
                .map(this::parseActivity)
                .collect(Collectors.toList());
    }

    private Activity parseActivity(String activity) {
        String[] splitActivity = activity.split(",");
        Activity.Type type;
        try {
            type = Activity.Type.valueOf(splitActivity[0]);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Illegal type argument passed in file");
        }
        long balance = Integer.parseInt(splitActivity[2]);
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't be less then zero");
        }
        return new Activity(type, splitActivity[1], balance);
    }
}
