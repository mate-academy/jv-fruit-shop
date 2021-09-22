package core.basesyntax.activity;

public interface ActivityStrategy {
    ActivityHandler getActivity(String activity);
}
