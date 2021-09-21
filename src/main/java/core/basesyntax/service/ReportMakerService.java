package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

import java.util.List;

public interface ReportMakerService {
    List<String> makeReport(FruitDao fruitDao);
}
