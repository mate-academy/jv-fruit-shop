package core.basesyntax.strategy;

public class FruitStrategyImpl {
    public FruitService getFruitService(String operation) {
        switch (operation) {
            case "p":
                return new Purchase();
            case "r":
                return new Return();
            case "s":
                return new Supply();
            case "b":
                return new Balance();
            default:
                throw new RuntimeException("Incorrect case of operation " + operation);
        }
    }
}
