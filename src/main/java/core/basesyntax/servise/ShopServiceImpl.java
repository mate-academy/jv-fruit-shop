package core.basesyntax.servise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private final ReaderService readerService;
    private final WriterService writerService;
    private final ActivityStrategy activityStrategy;

    public ShopServiceImpl(ReaderService readerService, WriterService writerService,
                           ActivityStrategy activityStrategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void availableFruitsAfterWorkShift() {
        List<List<String>> parsedLines;
        Map<String, Integer> goalMap = new HashMap<>();
        parsedLines = readerService.readData();
        for (List<String> line : parsedLines) {
            activityStrategy.getActivity(line.get(TYPE))
                    .act(line.get(FRUIT), line.get(QUANTITY), goalMap);
        }
        writerService.writeData(goalMap);
    }
}
