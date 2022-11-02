package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.util.List;

public class ScreenWriterServiceImpl implements DataWriterService {
    @Override
    public void writeData(List<String> dataList) {
        dataList.forEach(System.out::println);
    }
}
