package services.validation;

import model.TransactionDto;

public interface ValidateData {
    TransactionDto isDataOk(String record);
}
