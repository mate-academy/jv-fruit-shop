package core.basesyntax.service;

import core.basesyntax.model.OperationModel;
import java.util.List;

public interface FileParserService {
    List<OperationModel> parse(List<String> listFromFile);
}
