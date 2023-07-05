package core.shop.service.impl;

import core.shop.model.ActivityType;
import core.shop.service.FileService;
import core.shop.service.ShopOperationsService;

public class ShopOperationsServiceImpl implements ShopOperationsService {
    private static final String COMA_SEPARATOR = ",";
    private static final String DATABASE_FILE_CSV = "src/database.csv";
    private final FileService fileService = new FileServiceImpl();

    @Override
    public void addOperationToCsv(ActivityType activityType, String fruitName, int quantity) {
        StringBuilder operationBuilder = new StringBuilder();
        operationBuilder.append(activityType.getCode())
                .append(COMA_SEPARATOR)
                .append(fruitName)
                .append(COMA_SEPARATOR)
                .append(quantity)
                .append(System.lineSeparator());
        fileService.write(DATABASE_FILE_CSV, operationBuilder.toString());
    }
}
