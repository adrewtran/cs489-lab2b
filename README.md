PAMS CLI (Patients-Appointments Management System)

What I implemented
- Java Maven CLI app that creates a small set of Patient records, computes ages, sorts patients by age (oldest first), and writes the data to patients.json.
- Package: edu.miu.cs.cs489appsd.lab2b
- Main class: PAMSApp
- Model class: Patient

Build & run
1) Build the project and download dependencies:
   mvn clean package -DskipTests

2) Run the jar (from project root):
   java -jar target\pamscli-1.0-SNAPSHOT.jar

Output
- The program writes `patients.json` into the project root directory. Each patient object includes an `age` property and the `dateOfBirth` is formatted as yyyy-MM-dd.

Notes
- The project uses Jackson (jackson-databind and jackson-datatype-jsr310) to serialize LocalDate properly.
- If your IDE shows unresolved imports for Jackson before building, run the Maven build so the IDE can pick up the dependencies.

Contact
- If you want any additional features (CLI input, persistence, tests), tell me which you'd prefer and I'll add them.

