package vnuk.cse.scbanking.entity;

import java.util.Date;

public interface CommonTransaction {
    Double getAmount();
    Date getCreatedAt();
    String getTransactionName();
}
