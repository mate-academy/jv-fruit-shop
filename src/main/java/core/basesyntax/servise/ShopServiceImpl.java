package core.basesyntax.servise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private ReaderService readerService;
    private WriterService writerService;
    private ActivityStrategy activityStrategy;

    public ShopServiceImpl(ReaderService readerService, WriterService writerService,
                           ActivityStrategy activityStrategy) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public boolean availableFruitsAfterWorkShift() {
        List<List<String>> parsedLines;
        Map<String, Integer> goalMap = new HashMap<>();
        parsedLines = readerService.readData();
        for (int i = 0; i < parsedLines.size(); i++) {
            List<String> line = parsedLines.get(i);
            activityStrategy.getActivity(line.get(TYPE))
                    .action(line.get(FRUIT), line.get(QUANTITY), goalMap);
        }
        writerService.writeData(goalMap);
        return true;
    }
}
