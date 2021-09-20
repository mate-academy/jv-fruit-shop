package core.basesyntax.servise;

import core.basesyntax.model.FruitRecordDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
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
        List<FruitRecordDto> parsedLines;
        Map<String, Integer> goalMap = new HashMap<>();
        parsedLines = readerService.readData();
        for (FruitRecordDto line : parsedLines) {
            activityStrategy.getActivity(line.getTypeOperation())
                    .act(line.getFruit(), line.getQuantity(), goalMap);
        }
        writerService.writeData(goalMap);
    }
}
