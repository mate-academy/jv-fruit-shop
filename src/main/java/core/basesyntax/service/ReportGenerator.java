package core.basesyntax.service;

import core.basesyntax.model.Report;
import java.util.List;

public interface ReportGenerator {
    List<Report> generate();
}
