package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.ReaderService;
import core.basesyntax.dao.Validator;
import core.basesyntax.dao.WriterService;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private Validator validator = new Validator();
    private ReaderService readerService;
    private OperationStrategy operationStrategy;
    private WriterService writerService;

    public ShopServiceImpl(ReaderService readerService,
                           OperationStrategy operationStrategy, WriterService writerService) {
        this.readerService = readerService;
        this.operationStrategy = operationStrategy;
        this.writerService = writerService;
    }

    @Override
    public void getReport(String fromFile, String toFile) {
        validator.checkData(fromFile);
        List<String> listInfo = readerService.getDataFromFile(fromFile);
        for (String infoRow: listInfo) {
            operationStrategy.get(infoRow.split(","));
        }
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Fruit fruit: Storage.fruits) {
            stringBuilder.append("\n")
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity());
        }
        writerService.writeData(toFile,stringBuilder.toString());
    }
}
