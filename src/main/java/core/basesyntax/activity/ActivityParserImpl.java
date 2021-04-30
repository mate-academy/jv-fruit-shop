package core.basesyntax.activity;

public class ActivityParserImpl implements ActivityParser {
    private static final int ACTIVITY_TYPE = 0;
    private static final String VALID_ACTION = "[bspr]";

    @Override
    public Activities parseActivity(String line) {
        String receivedActivity = line.substring(ACTIVITY_TYPE, line.indexOf(","));
        if (!receivedActivity.matches(VALID_ACTION)) {
            throw new RuntimeException("Invalid input");
        }
        switch (line.charAt(ACTIVITY_TYPE)) {
            case 'b': return Activities.BALANCE;
            case 's': return Activities.SUPPLY;
            case 'p': return Activities.PURCHASE;
            case 'r': return Activities.RETURN;
            default: throw new RuntimeException("There is no such operation: " + line.charAt(ACTIVITY_TYPE));
        }
    }
}
