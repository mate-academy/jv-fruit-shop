package core.service;

import core.dao.FruitDao;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private FruitDao fruitService;

    public ReportCreatorServiceImpl(FruitDao fruitService) {
        this.fruitService = fruitService;
    }

    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        Map<String,Integer> fruitsMap = fruitService.getAll();
        for (Map.Entry<String,Integer> entry : fruitsMap.entrySet()) {
            stringBuilder.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        return stringBuilder.toString();
    }
}
