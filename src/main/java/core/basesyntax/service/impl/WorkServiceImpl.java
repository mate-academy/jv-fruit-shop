package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.WorkService;
import core.basesyntax.service.Writer;
import java.util.List;

public class WorkServiceImpl implements WorkService {
    private final Reader reader;
    private final Writer writer;
    private final ReportMaker reportMaker;
    private final Validator validator;
    private final ShopService shopService;

    public WorkServiceImpl(Reader reader, Writer writer,
                           ReportMaker reportMaker, Validator validator, ShopService shopService) {
        this.reader = reader;
        this.writer = writer;
        this.reportMaker = reportMaker;
        this.validator = validator;
        this.shopService = shopService;
    }

    @Override
    public void workShop(String inputFilePath, String outputFilePath) {
        List<String> inputData = reader.readFromFile(inputFilePath);
        if (validator.validateData(inputData)) {
            List<Fruit> fruits = shopService.updatingFruitStorage(inputData);
            String report = reportMaker.makeReport(fruits);
            writer.writeToFile(report, outputFilePath);
        }
    }
}
