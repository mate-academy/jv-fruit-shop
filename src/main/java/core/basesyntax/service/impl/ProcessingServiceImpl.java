package core.basesyntax.service.impl;

import core.basesyntax.service.ProcessingService;
import java.util.List;

public class ProcessingServiceImpl implements ProcessingService {

    @Override
    public void removeHeading(List<String> list) {
        list.remove(0);
    }
}
