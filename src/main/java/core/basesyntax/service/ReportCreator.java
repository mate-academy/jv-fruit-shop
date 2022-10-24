package core.basesyntax.service;

import java.time.LocalDate;

public interface ReportCreator {
    void createReport(String toPath, LocalDate date);
}
