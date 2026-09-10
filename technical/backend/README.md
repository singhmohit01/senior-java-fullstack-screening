# Fraud Management System - Backend

## Overview

The Fraud Management System is a Spring Boot based REST API application designed to manage fraud records and support a Maker-Checker approval workflow.

The application provides APIs to create, retrieve, update, delete, submit, approve, and reject fraud records.

This project is an independently developed technical demonstration inspired by common fraud and risk-management workflows. It does not contain or reproduce any proprietary source code, data, or implementation from any organization.

---

## Technology Stack

- Java 17
- Spring Boot 3.5.x
- Spring Web
- Spring Data MongoDB
- Spring Security
- Jakarta Bean Validation
- Lombok
- Maven
- JUnit 5
- Mockito

---

## Key Features

### 1. Fraud Record Management

The application supports complete CRUD operations:

- Create fraud record
- Get all fraud records
- Get fraud record by ID
- Update fraud record
- Delete fraud record

### 2. Maker-Checker Workflow

The application implements a basic Maker-Checker workflow:

```text
DRAFT
  |
  v
SUBMIT
  |
  v
PENDING_APPROVAL
  |
  +----------------+
  |                |
  v                v
APPROVED        REJECTED
