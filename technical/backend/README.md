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
   POST /submit-approval-submission
