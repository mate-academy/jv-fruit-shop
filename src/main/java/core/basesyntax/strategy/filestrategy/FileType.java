package core.basesyntax.strategy.filestrategy;

public enum FileType {
    CSV("csv");

    private final String name;

    FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
