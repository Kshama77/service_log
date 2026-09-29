# ServiceLog

ServiceLog is a simple Java console application for tracking service appointments.

## Features

- Add a service appointment
- View all appointments
- Search appointments by customer name
- Update appointment status
- Delete an appointment
- Uses Java classes, ArrayList, methods, loops, conditionals, and packages

## Technologies

- Java
- Java Collections (`ArrayList`)
- Console input with `Scanner`

## Project Structure

```text
ServiceLog/
├── src/
│   └── com/
│       └── servicelog/
│           ├── Main.java
│           ├── model/
│           │   └── Appointment.java
│           └── service/
│               └── AppointmentService.java
└── README.md
```

## How to Run

Open a terminal inside the project folder.

Compile:

```bash
javac -d out src/com/servicelog/model/Appointment.java src/com/servicelog/service/AppointmentService.java src/com/servicelog/Main.java
```

Run:

```bash
java -cp out com.servicelog.Main
```

## Example

```text
===== ServiceLog =====
1. Add Appointment
2. View Appointments
3. Search by Customer
4. Update Status
5. Delete Appointment
6. Exit
```

## Java Concepts Practiced

- Classes and objects
- Constructors
- Encapsulation
- ArrayList
- Methods
- Loops
- if/switch statements
- Scanner
- Packages
- Basic CRUD operations

## GitHub

After downloading and extracting the project:

```bash
git init
git add .
git commit -m "Initial ServiceLog project"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```
