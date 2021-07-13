package core.basesyntax.model;

import core.basesyntax.dao.ReportsDao;
import java.util.List;
import java.util.stream.Collectors;

public class RecordsMapperImpl implements RecordsMapper {
    private static final String SEPARATOR = ",";
    private static final String FILE_HEADER = "type,fruit,quantity";
    private final ReportsDao reportsDao;
    private final RecordsValidator recordsValidator;

    public RecordsMapperImpl(ReportsDao reportsDao, RecordsValidator recordsValidator) {
        this.reportsDao = reportsDao;
        this.recordsValidator = recordsValidator;
    }

    @Override
    public List<Record> map(String sourceFilename) {
        List<String> recordList = reportsDao.getRawRecords(sourceFilename);
        try{
            String header = recordList.remove(0);
            if (!header.equals(FILE_HEADER)) {
                throw new IllegalArgumentException("Input file has invalid header structure. "
                        + "Expected: " + FILE_HEADER + " but received: " + header);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Input file " + sourceFilename + " is empty " + e);
        }
        try {
            return recordList.stream()
                    .map((i) -> i.split(SEPARATOR))
                    .map((i) -> recordsValidator.validate(i[0], i[1], i[2]))
                    .collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Input file has corrupted columns structure" + e);
        }

    }
}
