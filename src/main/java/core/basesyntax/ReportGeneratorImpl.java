package core.basesyntax;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Storage.getFruits().forEach((fruit, quantity) -> report.append(fruit)
                        .append(",")
                        .append(quantity)
                        .append("\n"));
        return report.toString();
    }
}
