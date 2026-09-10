package fraudmanagement.service.impl;

import fraudmanagement.dto.FraudRecordRequest;
import fraudmanagement.dto.FraudRecordResponse;
import fraudmanagement.exception.FraudRecordNotFoundException;
import fraudmanagement.model.ApprovalStatus;
import fraudmanagement.model.FraudRecord;
import fraudmanagement.model.FraudStatus;
import fraudmanagement.repository.FraudRecordRepository;
import fraudmanagement.service.FraudRecordService;
import fraudmanagement.util.FraudRecordMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudRecordServiceImpl
        implements FraudRecordService {

    private final FraudRecordRepository repository;

    private final FraudRecordMapper mapper;

    @Override
    public FraudRecordResponse createRecord(
            FraudRecordRequest request) {

        FraudRecord record = mapper.toEntity(request);

        record.setFraudStatus(FraudStatus.SUSPECTED);

        record.setApprovalStatus(
                ApprovalStatus.DRAFT
        );

        record.setCreatedAt(
                LocalDateTime.now()
        );

        record.setUpdatedAt(
                LocalDateTime.now()
        );

        FraudRecord savedRecord =
                repository.save(record);

        return mapper.toResponse(savedRecord);
    }

    @Override
    public List<FraudRecordResponse> getAllRecords() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public FraudRecordResponse getRecordById(
            String id) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        return mapper.toResponse(record);
    }

    @Override
    public FraudRecordResponse updateRecord(
            String id,
            FraudRecordRequest request) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        record.setCustomerId(
                request.getCustomerId()
        );

        record.setAccountNumber(
                request.getAccountNumber()
        );

        record.setFraudType(
                request.getFraudType()
        );

        record.setTransactionAmount(
                request.getTransactionAmount()
        );

        record.setUpdatedAt(
                LocalDateTime.now()
        );

        FraudRecord updatedRecord =
                repository.save(record);

        return mapper.toResponse(updatedRecord);
    }

    @Override
    public void deleteRecord(String id) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        repository.delete(record);
    }

    @Override
    public FraudRecordResponse submitForApproval(
            String id) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        record.setApprovalStatus(
                ApprovalStatus.PENDING_APPROVAL
        );

        record.setUpdatedAt(
                LocalDateTime.now()
        );

        return mapper.toResponse(
                repository.save(record)
        );
    }

    @Override
    public FraudRecordResponse approveRecord(
            String id,
            String approvedBy) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        record.setApprovalStatus(
                ApprovalStatus.APPROVED
        );

        record.setApprovedBy(
                approvedBy
        );

        record.setUpdatedAt(
                LocalDateTime.now()
        );

        return mapper.toResponse(
                repository.save(record)
        );
    }

    @Override
    public FraudRecordResponse rejectRecord(
            String id) {

        FraudRecord record =
                repository.findById(id)
                        .orElseThrow(() ->
                                new FraudRecordNotFoundException(
                                        "Fraud record not found: " + id
                                )
                        );

        record.setApprovalStatus(
                ApprovalStatus.REJECTED
        );

        record.setUpdatedAt(
                LocalDateTime.now()
        );

        return mapper.toResponse(
                repository.save(record)
        );
    }
}
