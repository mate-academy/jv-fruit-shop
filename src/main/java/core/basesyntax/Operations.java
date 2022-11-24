package core.basesyntax;

public enum Operations {
    BALANCE,
    SUPPLY,
    PURCHASE,
    RETURN;

    public static Operations getByCode(String code) {
        switch (code) {
            case "s":
                return SUPPLY;
            case "p":
                return PURCHASE;
            case "r":
                return RETURN;
            case "b":
            default:
                return BALANCE;
        }
    }
}
