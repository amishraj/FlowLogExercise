# Flow Log Parser Exercise

## Overview

This Java application parses a file containing flow log data and maps each row to a tag based on a lookup table. The lookup table is defined as a CSV file, and it has 3 columns: `dstport`, `protocol`, and `tag`. The combination of `dstport` and `protocol` determines the tag that can be applied. 

This exercise was done as part of Ilumio's technical assessment.
Author: Amish Raj

## Features

- Parses flow log files in a fixed format (AWS VPC Flow Logs version 2).
- Uses a lookup table to map port-protocol combinations to specific tags.
- Outputs the count of matches for each tag and each port/protocol combination.
- Provides detailed unit tests for all core functionality.

## Assumptions

1. **Unique Port-Protocol Combination for Each Tag**: Each `dstport` and `protocol` combination in the lookup table maps uniquely to a tag.
2. **Flow Log Entry Order**: The flow log entries are expected to be in the following order: version, account ID, eni ID, source IP, destination IP, destination port, source port, protocol, packets, bytes, start time, end time, action, and status.
3. **Input File Validity**: The application assumes that the input files (`lookup.csv` and `flow_logs.txt`) contain valid data.
4. **Field Types as per AWS Documentation**: Fields in the flow log are assumed to have the same data types as specified in the AWS documentation for VPC Flow Logs.
5. **Output Directory**: All application and test output files are stored in the `output/` directory.
6. **JavaDoc Generation**: Java documentation is generated and stored in the `doc/` directory.

## Directory Structure


## Setup and Execution

### Prerequisites

- Java 11 or higher
- Gradle or Maven (depending on your build system)

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
