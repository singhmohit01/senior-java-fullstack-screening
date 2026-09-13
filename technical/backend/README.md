# Fraud Management System - recent project

The Fraud Management System is a Spring Boot-based REST API application designed to manage fraud records and implement a Maker-Checker approval workflow.

The application supports fraud-data ingestion through CSV uploads, along with record-level edit and delete operations from the React.js frontend. Operations initiated by a Maker are submitted for approval and become visible to the appropriate Checker based on the user's hierarchy. The Checker can review the submitted request and perform the required action, such as approve, reject, or delete the request.

## Functional Flow

1. **Maker Operations**
   - A Maker can upload CSV files containing fraud data.
   - A Maker can edit or delete existing fraud records from the React.js frontend.
   - These operations do not directly modify the final approved data.
   - Instead, they generate an approval submission that is routed to the appropriate Checker based on the user's hierarchy.

2. **Maker-Checker Approval**
   - The Checker can view pending submissions from the respective frontend screen.
   - The Checker can review the submission and asynchronously **approve, reject, or delete** the request.
   - The approval workflow ensures that changes to fraud data are reviewed before becoming effective.

3. **Approval Submission API**

   The primary endpoint for initiating the approval workflow is:

   ```text
   **POST /submit-approval-submission**

This endpoint creates and submits an approval request for operations such as CSV uploads, record updates, and deletions. The request is then made available to the appropriate Checker for review.

Record Status API

The application provides:

   ```text
   **GET /record-status**

This endpoint retrieves fraud records along with their submission and approval information. The React.js frontend uses this information to display the current status of each request and its associated approval details.

### CSV Upload and AWS S3 Processing
   - CSV files submitted by a Maker are first processed through the approval workflow.
   - The file is uploaded to AWS S3 only after the corresponding approval is completed.
   - Once approved, the file can be retrieved from S3 and processed to populate the required downstream fraud-data views.
   - This ensures that unapproved CSV data is not treated as finalized fraud data.
 **Asynchronous Processing**
   - Approval submissions, CSV processing, and related backend operations are handled asynchronously where applicable.
   - This prevents long-running operations from blocking the user-facing API request and improves application responsiveness.
   - The asynchronous approach also allows the system to process larger data volumes more efficiently.
**Data Persistence**
   - **MongoDB** is used to persist fraud records, approval submissions, workflow status, and related metadata.
   - The data model maintains the relationship between fraud records and their corresponding Maker-Checker submission and approval details.
   - The backend exposes REST APIs consumed by the **React.js frontend** to display fraud records, submission details, and the current approval status.

                 React.js Frontend
                        |
                        v
              +---------------------+
              |       Maker         |
              | Upload / Edit /     |
              |      Delete         |
              +----------+----------+
                         |
                         v
             POST /submit-approval-submission
                         |
                         v
              +---------------------+
              | Approval Submission |
              |     / Workflow      |
              +----------+----------+
                         |
                         v
                Appropriate Checker
                         |
                +--------+--------+
                |        |        |
             APPROVE   REJECT   DELETE
                |
                v
          AWS S3 / Processing
                |
                v
             MongoDB
                |
                v 
       GET /record-status
                |
                v
          React.js Frontend
