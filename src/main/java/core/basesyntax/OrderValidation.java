package core.basesyntax;

public class OrderValidation {
    private static final String REGEX_FOR_OPERATIONS = "[sbr]";

    public void toCheckOrder(String[] order) {
        if (order.length < 4) {
            throw new RuntimeException("Wrong format. We need more data");
        }
        if (!(order[0].matches(REGEX_FOR_OPERATIONS))) {
            throw new RuntimeException("We don't have such operation");
        }
    }
}
