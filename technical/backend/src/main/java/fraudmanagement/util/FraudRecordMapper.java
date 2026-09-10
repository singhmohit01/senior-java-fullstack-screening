package fraudmanagement.util;

import fraudmanagement.dto.FraudRecordRequest;
import fraudmanagement.dto.FraudRecordResponse;
import fraudmanagement.model.FraudRecord;

import org.springframework.stereotype.Component;

@Component
public class FraudRecordMapper {

    public FraudRecord toEntity(
            FraudRecordRequest request) {

        return FraudRecord.builder()
                .customerId(
                        request.getCustomerId()
                )
                .accountNumber(
                        request.getAccountNumber()
                )
                .fraudType(
                        request.getFraudType()
                )
                .transactionAmount(
                        request.getTransactionAmount()
                )
                .createdBy(
                        request.getCreatedBy()
                )
                .build();
    }

    public FraudRecordResponse toResponse(
            FraudRecord record) {

        return FraudRecordResponse.builder()
                .id(record.getId())
                .customerId(
                        record.getCustomerId()
                )
                .accountNumber(
                        record.getAccountNumber()
                )
                .fraudType(
                        record.getFraudType()
                )
                .transactionAmount(
                        record.getTransactionAmount()
                )
                .fraudStatus(
                        record.getFraudStatus()
                )
                .approvalStatus(
                        record.getApprovalStatus()
                )
                .createdBy(
                        record.getCreatedBy()
                )
                .approvedBy(
                        record.getApprovedBy()
                )
                .createdAt(
                        record.getCreatedAt()
                )
                .updatedAt(
                        record.getUpdatedAt()
                )
                .build();
    }
}
