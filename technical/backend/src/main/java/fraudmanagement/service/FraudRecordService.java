package fraudmanagement.service;

import fraudmanagement.dto.FraudRecordRequest;
import fraudmanagement.dto.FraudRecordResponse;

import java.util.List;

public interface FraudRecordService {

    FraudRecordResponse createRecord(
            FraudRecordRequest request
    );

    List<FraudRecordResponse> getAllRecords();

    FraudRecordResponse getRecordById(
            String id
    );

    FraudRecordResponse updateRecord(
            String id,
            FraudRecordRequest request
    );

    void deleteRecord(
            String id
    );

    FraudRecordResponse submitForApproval(
            String id
    );

    FraudRecordResponse approveRecord(
            String id,
            String approvedBy
    );

    FraudRecordResponse rejectRecord(
            String id
    );
}
