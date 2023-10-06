package service.impl;

import dao.FruitShopDao;
import db.FruitShop;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;
import service.WriterFileService;

public class ReportServiceImpl implements ReportService {
    private final FruitShopDao fruitShopDao;
    private final WriterFileService writer = new WriterFileServiceImpl();

    public ReportServiceImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void createReport() {
        //стоворюємо репорт
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        Map<String, Integer> collectFruit = FruitShop.fruitShop.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(FruitTransaction::getQuantity)));
        collectFruit.forEach((fruit, quantity) ->
                report.append(fruit).append(",").append(quantity).append(System.lineSeparator()));
        writer.writeToFile(report.toString());
    }
}
