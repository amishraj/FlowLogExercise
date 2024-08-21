# Flow Log Parser Exercise

## Overview

This Java application parses a file containing flow log data and maps each row to a tag based on a lookup table. The lookup table is defined as a CSV file, and it has 3 columns: `dstport`, `protocol`, and `tag`. The combination of `dstport` and `protocol` determines the tag that can be applied.

This exercise was done as part of Ilumio's technical assessment. A test driven development approach was followed as a way of designing the solution.
Author: Amish Raj

## Features

- Parses flow log files in a fixed format (AWS VPC Flow Logs version 2). Ref: https://docs.aws.amazon.com/vpc/latest/userguide/flow-log-records.html
- Uses a lookup table to map port-protocol combinations to specific tags.
- Outputs the count of matches for each tag and each port/protocol combination.
- Provides detailed unit tests for all core functionality.

## Assumptions

1. **Unique Port-Protocol Combination for Each Tag**: Each `dstport` and `protocol` combination in the lookup table maps uniquely to a tag.
2. **Flow Log Entry Order**: The flow log entries are expected to be in the following default order: version, account ID, eni ID, source IP, destination IP, destination port, source port, protocol, packets, bytes, start time, end time, action, and status.
3. **Version**: Only version 2 is supported for the logs
4. **Protocol**: The application only expects TCP, UDP, and ICMP protocols, however more can be easily added later as per need.
5. **Input File Validity**: The application assumes that the input files (`lookup.csv` and `flow_logs.txt`) always contain valid data.
6. **Field Types as per AWS Documentation**: Fields in the flow log are assumed to have the same data types as specified in the AWS documentation for VPC Flow Logs.
7. **Output Directory**: All application AND test output files are stored in the `output/` directory, for easy unit testing; that can be modified later as the application scales.

## Directory Structure

src/ contains the program files, intuitively organized into the main and test directories. FlowlogexerciseApplication.java is the driver class and is the starting point of the application.

The model class contains the flow log entry and lookup entry classes.

The service and util classes are self explanatory helper classes that perform the essential functions of the application as specified in the problem statement.

The src/test/java directory includes the implemented Unit Tests for each of the model, service, and util classes.

The src/main/Resources directory contains the input flow_logs.txt and lookup.csv files which the application parses.

Both Test and Application Output Files (port_protocol_counts.txt, tag_counts.txt, test_port_protocol_counts.txt, test_tag_counts.txt) are stored in the ./output/ directory.

```bash
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.flowlogexercise/
│   │   │   │   └── FlowlogexerciseApplication.java
│   │   │   ├── model/
│   │   │   │   ├── FlowLogEntry.java
│   │   │   │   └── LookupEntry.java
│   │   │   ├── service/
│   │   │   │   ├── FlowLogService.java
│   │   │   │   └── LookupService.java
│   │   │   └── util/
│   │   │       ├── FileReaderUtil.java
│   │   │       └── ResultWriterUtil.java
│   │   └── Resources/
│   │       ├── application.properties
│   │       ├── flow_logs.txt
│   │       └── lookup.csv
│   └── test/
│       └── java/
│           ├── com.example.flowlogexercise/
│           │   └── FlowlogexerciseApplicationTests.java
│           ├── model/
│           │   ├── FlowLogEntryTest.java
│           │   └── LookupEntryTest.java
│           ├── service/
│           │   ├── FlowLogServiceTest.java
│           │   └── LookupServiceTest.java
│           └── util/
│               ├── FileReaderUtilTest.java
│               └── ResultWriterUtilTest.java
├── JRE System Library/
├── Project and External Dependencies/
├── JUnit 5/
├── bin/
├── gradle/
├── output/
│   ├── port_protocol_counts.txt
│   ├── tag_counts.txt
│   ├── test_port_protocol_counts.txt
│   └── test_tag_counts.txt
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

## Setup and Execution

### Prerequisites

- Java 17 or higher
- Gradle
- IntelliJ or Spring Tool Suite IDE is recommended

### Build and Run

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your-username/your-project.git
    cd your-project
    ```

2. **Build the Project:**

    If using Gradle:

    ```bash
    ./gradlew build
    ```

    If using Maven:

    ```bash
    mvn clean install
    ```

3. **Run the Application:**

    ```bash
    ./gradlew run
    ```

    or

    ```bash
    mvn exec:java -Dexec.mainClass="com.illumio.FlowlogexerciseApplication"
    ```

4. **View the Output:**

   The application output will be stored in the `output/` directory.

5. **Run the Tests:**

    ```bash
    ./gradlew test
    ```

    or

    ```bash
    mvn test
    ```
