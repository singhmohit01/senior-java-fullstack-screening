package fraudmanagement.repository;

import fraudmanagement.model.ApprovalStatus;
import fraudmanagement.model.FraudRecord;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FraudRecordRepository
        extends MongoRepository<FraudRecord, String> {

    List<FraudRecord> findByCustomerId(String customerId);

    List<FraudRecord> findByApprovalStatus(
            ApprovalStatus approvalStatus
    );
}
