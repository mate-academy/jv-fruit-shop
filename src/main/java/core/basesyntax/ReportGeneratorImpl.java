import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Map<String, Integer> fruitStorage;

    public ReportGeneratorImpl(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
