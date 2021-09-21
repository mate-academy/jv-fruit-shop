package services.readfromfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import model.TransactionDto;
import services.validation.ValidateData;
import services.validation.ValidateDataImpl;

public class ReadingFromFileImpl implements ReadingFromFile {
    private static final String FIRST_LINE = "type,fruit,quantity";

    @Override
    public List<TransactionDto> readingFromFile(String filePath) {
        List<String> stringsRecords;
        try {
            stringsRecords = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new ReadingException("Can't read a file!", e);
        }
        ValidateData validateData = new ValidateDataImpl();
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (String stringsRecord : stringsRecords) {
            if (stringsRecord.equals(FIRST_LINE)) {
                continue;
            }
            TransactionDto transactionDto = validateData.isDataOk(stringsRecord);
            transactionDtoList.add(transactionDto);
        }
        return transactionDtoList;
    }
}
