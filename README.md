# Pharmacy Medicine Stock & Prescription System

A Java-based console application for managing pharmacy medicine stocks and prescriptions.

## Features

- **Issue Prescription**: Issue medicines to patients, validating stock availability.
- **Cancel Prescription**: Cancel existing prescriptions and update stock.
- **Stock Management**: Automatically updates medicine stock upon issuance or cancellation.

## Technologies Used

- **Language**: Java
- **Database**: Oracle Database Express Edition (XE)
- **Persistence**: JDBC (Java Database Connectivity)

## Prerequisites

1.  **Java Development Kit (JDK)** installed.
2.  **Oracle Database XE** installed and running locally.
3.  **Oracle JDBC Driver** (`ojdbc.jar`) added to the project classpath.

## Database Setup

1.  Ensure your Oracle Database is running on `localhost:1521:xe`.
2.  Create a user/schema with the following credentials (or update `src/com/pharmacy/util/DBUtil.java`):
    - **Username**: `pharmacy`
    - **Password**: `pharmacy123`
3.  Ensure the necessary tables (`medicines`, `prescriptions`, etc.) are created in the database.

## Project Structure

```text
src/com/pharmacy/
├── app/          # Main entry point (PharmacyMain.java)
├── bean/         # Data models (Medicine, Prescription)
├── dao/          # Data Access Objects (Database operations)
├── service/      # Business logic
└── util/         # Utilities (DB Connection, Exceptions)
```

## How to Run

1.  Compile the project ensuring `ojdbc` is in the classpath.
2.  Run the main class: `com.pharmacy.app.PharmacyMain`.
3.  Follow the on-screen prompts to issue or cancel prescriptions.
