package services.readfromfile;

import java.util.List;
import model.TransactionDto;

public interface ReadingFromFile {
    List<TransactionDto> readingFromFile(String filePath);
}
