package fraudmanagement.controller;

import fraudmanagement.dto.FraudRecordRequest;
import fraudmanagement.dto.FraudRecordResponse;
import fraudmanagement.service.FraudRecordService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-records")
@RequiredArgsConstructor
public class FraudRecordController {

    private final FraudRecordService fraudRecordService;

    @PostMapping
    public ResponseEntity<FraudRecordResponse> createRecord(
            @Valid @RequestBody FraudRecordRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        fraudRecordService.createRecord(request)
                );
    }

    @GetMapping
    public ResponseEntity<List<FraudRecordResponse>>
    getAllRecords() {

        return ResponseEntity.ok(
                fraudRecordService.getAllRecords()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudRecordResponse>
    getRecordById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                fraudRecordService.getRecordById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudRecordResponse>
    updateRecord(
            @PathVariable String id,
            @Valid @RequestBody FraudRecordRequest request) {

        return ResponseEntity.ok(
                fraudRecordService.updateRecord(
                        id,
                        request
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(
            @PathVariable String id) {

        fraudRecordService.deleteRecord(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<FraudRecordResponse>
    submitForApproval(
            @PathVariable String id) {

        return ResponseEntity.ok(
                fraudRecordService.submitForApproval(id)
        );
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<FraudRecordResponse>
    approveRecord(
            @PathVariable String id,
            @RequestParam String approvedBy) {

        return ResponseEntity.ok(
                fraudRecordService.approveRecord(
                        id,
                        approvedBy
                )
        );
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<FraudRecordResponse>
    rejectRecord(
            @PathVariable String id) {

        return ResponseEntity.ok(
                fraudRecordService.rejectRecord(id)
        );
    }
}
