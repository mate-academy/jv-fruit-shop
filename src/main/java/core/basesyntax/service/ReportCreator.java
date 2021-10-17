package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;

import java.util.List;

public interface ReportCreator {
    String createReport(List<FruitOperation> data);
}
