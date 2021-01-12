package strategy;

import dto.Storage;
import model.CurrentBalance;

public interface ActivitiesStrategy {
    CurrentBalance doAction(Storage storage, CurrentBalance currentBalance);
}
