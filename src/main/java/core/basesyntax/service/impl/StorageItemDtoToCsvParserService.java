package core.basesyntax.service.impl;

import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class StorageItemDtoToCsvParserService implements ParserService<String> {
    private static final String CSV_COMMA_SEPARATOR = ",";
    private final List<StorageItemDto> storageItemList;
    private final List<String> headers;

    public StorageItemDtoToCsvParserService(List<StorageItemDto> storageItemList,
                                            List<String> headers) {
        this.storageItemList = storageItemList;
        this.headers = headers;
    }

    @Override
    public List<String> parse() {
        List<String> remaindersList = new ArrayList<>();

        if (headers != null && !headers.isEmpty()) {
            remaindersList.add(String.join(CSV_COMMA_SEPARATOR, headers));
        }

        for (StorageItemDto storageItem : storageItemList) {
            String csvStorageItem = storageItem.getName()
                    + CSV_COMMA_SEPARATOR + storageItem.getQty();

            remaindersList.add(csvStorageItem);
        }

        return remaindersList;
    }
}
