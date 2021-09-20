package core.basesyntax.servise;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.storage.Storage;
import java.util.List;

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
        parsedLines = readerService.readData();
        for (FruitRecordDto line : parsedLines) {
            activityStrategy.getActivity(line.getTypeOperation())
                    .act(line.getFruit(), line.getQuantity());
        }
        writerService.writeData(Storage.fruitsDataBase);
    }
}
