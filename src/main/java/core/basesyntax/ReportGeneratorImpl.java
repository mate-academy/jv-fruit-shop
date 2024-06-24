import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private final Map<String, Integer> fruitStorage;

    public ReportGeneratorImpl(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            report.append(entry.getKey())
                  .append(",")
                  .append(entry.getValue())
                  .append(System.lineSeparator());
        }
        return report.toString();
    }
}
