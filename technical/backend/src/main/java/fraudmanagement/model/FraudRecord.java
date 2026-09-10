package fraudmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fraud_records")
public class FraudRecord {

    @Id
    private String id;

    private String customerId;
    private String accountNumber;
    private String fraudType;
    private Double transactionAmount;

    private FraudStatus fraudStatus;
    private ApprovalStatus approvalStatus;

    private String createdBy;
    private String approvedBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
