package core.service;

import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String DELIMITER = ",";
    private FruitService fruitService;

    public ReportCreatorServiceImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        Map<String,Integer> fruitsMap = fruitService.getAll();
        for (Map.Entry<String,Integer> entry : fruitsMap.entrySet()) {
            stringBuilder.append(entry.getKey() + DELIMITER + entry.getValue() + "\n");
        }
        return stringBuilder.toString();
    }
}
