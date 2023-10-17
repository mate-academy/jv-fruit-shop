package core.basesyntax.service.impl;

import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.List;

public class StorageItemDtoToCsvParserService implements ParserService<String> {
    private static final String CSV_COMMA_SEPARATOR = ",";
    private final List<StorageItemDTO> storageItemList;
    private final List<String> headers;

    public StorageItemDtoToCsvParserService(List<StorageItemDTO> storageItemList, List<String> headers) {
        this.storageItemList = storageItemList;
        this.headers = headers;
    }

    @Override
    public List<String> parse() {
        List<String> remaindersList = new ArrayList<>();

        if (headers != null && !headers.isEmpty()) {
            remaindersList.add(String.join(CSV_COMMA_SEPARATOR, headers));
        }

        for (StorageItemDTO storageItem : storageItemList) {
            String csvStorageItem = storageItem.getName()
                    + CSV_COMMA_SEPARATOR + storageItem.getQty();

            remaindersList.add(csvStorageItem);
        }

        return remaindersList;
    }
}
