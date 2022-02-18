package core.basesyntax.startegy;

public interface ActivityStrategy {
    ActivityHandler get(ActivityType type);
}
