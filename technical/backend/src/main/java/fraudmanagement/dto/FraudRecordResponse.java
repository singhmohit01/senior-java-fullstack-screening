package fraudmanagement.dto;

import fraudmanagement.model.ApprovalStatus;
import fraudmanagement.model.FraudStatus;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FraudRecordResponse {

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
