# [System Design Approach](https://github.com/shivam-maharshi/oop-designs/edit/master/sda)

System design approach explains a basic appproach that should be followed while solving any architectural or system level design questions. Questions like design Monitoring or Search & Recommendation Systems and products like AWS, Netflix, Uber etc. fall into these categories. The aim here is to create an efficient yet generic enough approach that can be applied to a variety of architectural & high level design problems.

## [Approach](https://github.com/shivam-maharshi/oop-designs/edit/master/sda)

### 1. Features - [2 mins]
* 1.1 Scale - Data size, Message size, User numbers
* 1.2 Main Features

### 2. Estimations - [5 mins]
* 2.1 System Total Data & Storage Size
* 2.2 Total Queries Per Seconds
* 2.3 Minimum Machines

### 3. Design Goals - [2 mins]
* 3.1 Latency, Consistency, Availability, Partition Tolerance
* 3.2 CAP Theorem
* 3.3 What's important for this system/product?

### 4. Skeleton Of Design - [5 mins]
* 4.1 Operations Supported
* 4.2 Client API Design - Input, Output, Data Structures & URLs
* 4.3 APIs Usage Flow

### 5. Dive Deep - [20 - 30 mins]
* 5.1 Application Layer - Load Balancers
* 5.2 Database Layer - SQL or NoSQL?
*     5.2.1 Joins Required?
*     5.2.2 Data Size?
*     5.2.3 Read Write Pattern?
*     5.2.4 Sharding Required?
*     5.2.5 Fault Tolerance?
*     5.2.6 Availability?
* 5.3 Improve Efficieny With Caching & Consistent Hashing
