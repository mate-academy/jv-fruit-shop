package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitBalanceDao;
import core.basesyntax.model.FruitBalance;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private final FruitBalanceDao fruitBalanceDao;

    public ReportGeneratorImpl(FruitBalanceDao fruitBalanceDao) {
        this.fruitBalanceDao = fruitBalanceDao;
    }

    @Override
    public String getReport() {
        List<FruitBalance> info = fruitBalanceDao.get();
        return info.stream()
                .map(s -> s.getFruit() + COMMA + s.getBalance())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
