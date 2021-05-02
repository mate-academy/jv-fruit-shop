package fruitshop.service.shopoperation;

public enum OperationType {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private final String shortCut;

    OperationType(String shortCut) {
        this.shortCut = shortCut;
    }

    public String getShortCut() {
        return shortCut;
    }
}
