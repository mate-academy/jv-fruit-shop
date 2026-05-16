package core.basesyntax;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        for (String fruit : storage.allFruits()) {
            stringBuilder.append(fruit).append(",").append(storage.getFruit(fruit)).append("\n");
        }
        return stringBuilder.toString();
    }
}
