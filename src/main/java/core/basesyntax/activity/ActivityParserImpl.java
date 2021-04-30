package core.basesyntax.activity;

public class ActivityParserImpl implements ActivityParser {
    private static final int ACTIVITY_TYPE = 0;

    @Override
    public Activities parseActivity(String line) {
        switch (line.charAt(ACTIVITY_TYPE)) {
            case 'b': return Activities.BALANCE;
            case 's': return Activities.SUPPLY;
            case 'p': return Activities.PURCHASE;
            case 'r': return Activities.RETURN;
            default: throw new RuntimeException("There is no such operation: "
                    + line.charAt(ACTIVITY_TYPE));
        }
    }
}
