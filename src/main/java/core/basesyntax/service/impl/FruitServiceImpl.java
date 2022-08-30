package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.AmountStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String DIVIDER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int STARTING_AMOUNT = 0;
    private final ReportService reportService;
    private final AmountStrategy strategy;
    private final FruitDao fruitDao;
    private final ReaderService readerService;
    private final WriterService writerService;

    public FruitServiceImpl(AmountStrategy strategy, FruitDao fruitDao, ReaderService readerService,
                            WriterService writerService, ReportService reportService) {
        this.strategy = strategy;
        this.fruitDao = fruitDao;
        this.readerService = readerService;
        this.writerService = writerService;
        this.reportService = reportService;
    }

    @Override
    public void processData(String inputFile, String outputFile) {
        List<String> inputFruits = readerService.readFromFile(inputFile);
        for (int i = 1; i < inputFruits.size(); i++) {
            String[] fruitIncoming = inputFruits.get(i).split(DIVIDER);
            String operation = fruitIncoming[OPERATION_INDEX];
            String fruitName = fruitIncoming[NAME_INDEX];
            int fruitAmount = Integer.parseInt(fruitIncoming[AMOUNT_INDEX]);
            Fruit fruit = fruitDao.getByName(fruitName)
                    .orElseGet(() -> fruitDao.add(new Fruit(fruitName, STARTING_AMOUNT)));
            fruit.setAmount(strategy.get(operation).changeAmount(fruit, fruitAmount));
        }
        writerService.writeToFile(reportService.report(), outputFile);
    }
}
