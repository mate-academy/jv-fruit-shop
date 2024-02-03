package core.basesyntax.model;

public class FruitResultingRow {
    private final String fruitName;
    private final int fruitCount;

    public FruitResultingRow(String fruitName, int fruitCount) {
        this.fruitName = fruitName;
        this.fruitCount = fruitCount;
    }

    public String toCsv() {
        return fruitName + "," + fruitCount;
    }

    @Override
    public String toString() {
        return "FruitResultingRow{"
                + "fruitName='" + fruitName
                + ", fruitCount=" + fruitCount
                + '}';
    }
}
