package servise.impl;

import dao.ItemDao;
import java.util.List;
import java.util.Map;
import servise.ShopService;
import servise.TransactionService;

public class ShopServiceImpl implements ShopService {
    private final ItemDao itemDao;
    private final TransactionService transactionService;

    public ShopServiceImpl(ItemDao itemDao, TransactionService transactionService) {
        this.itemDao = itemDao;
        this.transactionService = transactionService;
    }

    @Override
    public void process(List<String> records) {
        records.stream()
                .filter(r -> !r.startsWith("type")) //without title row
                .map(transactionService::createTransaction)
                .forEach(itemDao::process);
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> record : itemDao.getRecords()) {
            report.append(System.lineSeparator())
                    .append(record.getKey())
                    .append(",")
                    .append(record.getValue());
        }
        return report.toString();
    }
}
