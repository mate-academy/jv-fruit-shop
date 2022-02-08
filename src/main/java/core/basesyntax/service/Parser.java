package core.basesyntax.service;

import java.util.List;

public interface Parser {
    String formatReport(List<String> data);

    List<String[]> formatInputData(List<String> data);
}
