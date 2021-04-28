package core.basesyntax.activity;

public class ActivityParserImpl implements ActivityParser {
    @Override
    public Activities parseActivity(String[] line) {
        switch (line[0]) {
            case "b": return Activities.BALANCE;
            case "s": return Activities.SUPPLY;
            case "p": return Activities.PURCHASE;
            case "r": return Activities.RETURN;
            default: throw new RuntimeException("There is no such operation: " + line[0]);
        }
    }
}
