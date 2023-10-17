package core.basesyntax.service.impl;

import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class CsvToStorageOperationDtoParserService implements ParserService<StorageOperationDto> {
    private static final int OPERATION_TYPE_FILED_INDEX = 0;
    private static final int STORAGE_ITEM_NAME_FILED_INDEX = 1;
    private static final int STORAGE_ITEM_QUANTITY_FIELD_INDEX = 2;
    private static final int CSV_MIN_FIELDS_NUMBER = 3;
    private static final String CSV_COMMA_SEPARATOR = ",";
    private final List<String> data;
    private final boolean headersPresent;

    public CsvToStorageOperationDtoParserService(List<String> data, boolean headersPresent) {
        this.data = data;
        this.headersPresent = headersPresent;
    }

    @Override
    public List<StorageOperationDto> parse() {
        List<StorageOperationDto> storageOperationList = new ArrayList<>();
        int startLine = headersPresent ? 1 : 0;

        for (int i = startLine; i < data.size(); i++) {
            String[] csvDataLine = data.get(i).split(CSV_COMMA_SEPARATOR);
            try {
                validateCsvLine(csvDataLine, i);
                storageOperationList.add(parseCsvLine(csvDataLine));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Parsing failed! Invalid data at line: " + i, e);
            }
        }

        return storageOperationList;
    }

    private void validateCsvLine(String[] csvDataLine, int csvLineIndex) {
        if (csvDataLine.length < CSV_MIN_FIELDS_NUMBER
                || csvDataLine[OPERATION_TYPE_FILED_INDEX].isBlank()
                || csvDataLine[STORAGE_ITEM_NAME_FILED_INDEX].isBlank()
                || csvDataLine[STORAGE_ITEM_QUANTITY_FIELD_INDEX].isBlank()) {
            throw new RuntimeException("Parsing failed! Invalid data at line: " + csvLineIndex);
        }
    }

    private StorageOperationDto parseCsvLine(String[] csvDataLine) {
        StorageItemDto storageItem =
                new StorageItemDto(csvDataLine[STORAGE_ITEM_NAME_FILED_INDEX],
                        Double.parseDouble(csvDataLine[STORAGE_ITEM_QUANTITY_FIELD_INDEX].trim()));

        StorageOperationDto storageOperation =
                new StorageOperationDto(csvDataLine[OPERATION_TYPE_FILED_INDEX],
                        storageItem);

        return storageOperation;
    }
}
