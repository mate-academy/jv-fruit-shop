package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ReportCreator {
    List<String> createReport(List<TransactionDto> parsedInfo);
}
