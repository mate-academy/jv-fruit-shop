package service.impl;

import db.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.FruitOperationsService;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    public static final String PURCHASE_OPERATION = "p";
    public static final String RETURN_OPERATION = "r";
    public static final String SUPPLY_OPERATION = "s";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private FruitOperationsService fruitOperationsService;

    @Override
    public boolean makeStockReportToCsvFile(List<FruitRecordDto> dtos) {
        for (FruitRecordDto dto : dtos) {
            switch (dto.getOperationType()) {
                case RETURN_OPERATION:
                case SUPPLY_OPERATION:
                    fruitOperationsService = new AddOperation();
                    fruitOperationsService.apply(dto);
                    break;
                case PURCHASE_OPERATION:
                    fruitOperationsService = new RemoveOperation();
                    fruitOperationsService.apply(dto);
                    break;
                default: break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.fruits.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey()
                                                  .getFruitName())
                         .append(",")
                         .append(fruitIntegerEntry.getValue())
                         .append('\n');
        }
        Path path = Path.of(OUTPUT_FILE_NAME);
        try {
            Files.write(path, stringBuilder.toString()
                                           .getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Can`t write to file " + OUTPUT_FILE_NAME);
        }
        return true;
    }
}
