package core.basesyntax.data;

import core.basesyntax.dto.Dto;
import java.util.List;

public interface DataAnalyzer {
    void analyze(List<Dto> listWithDtos);
}

