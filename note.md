1. Add Generated Sources to Build Path
   Sometimes Maven does not recognize `target/generated-sources` as a source folder, so you need to add it manually:

A. In IntelliJ IDEA:
Go to `File → Project Structure → Modules`.
Navigate to `medicalstore (your project) → target/generated-sources`.
Right-click on `target/generated-sources` → `Mark Directory as → Sources Root`.
Then click `Apply` and `OK`.

B. In VS Code:
Press `Ctrl + Shift + P` and search for `Java: Configure Classpath`.
Add `target/generated-sources` as a Source Folder.

C. In Eclipse:
Right-click on the Project → `Properties → Java Build Path → Source Tab`.
Click `Add Folder` and select `target/generated-sources`.
Click `Apply and Close`.

2. Run Maven Clean and Install
   If the files are still not accessible, rebuild the project with Maven:

```sh
mvn clean install
```

Or click `Maven → Reimport` in IntelliJ/Eclipse.

src/main/java/com/medicalstore/
│── generated/
│ ├── Medicine.java # DTO (Data Transfer Object)
│ ├── Query.java # API Interface for Queries
│ ├── Mutation.java # API Interface for Mutations
│ ├── client/
│ │ ├── MedicineGraphQLClient.java # GraphQL API Client
│── resolver/
│ ├── MedicineGraphQLResolver.java # Implements Resolvers
│── controller/
│ ├── MedicineController.java # Optional REST Controller

<!-- create folders structure template  -->

src/main/
|-java/com/medicalstore/medicalstore/
| |-controllers/
| |-handlers/
| |-resolvers/
| |-services/
| |-utils/
| |-response/
| |-MedicalstoreApplication.java
|
|-resources/
| |-static/
| |-templates/
| |-graphql/
| | |-commom.graphql
| | |-dashboard.graphql
| | |-medicines.graphql
| | |-schema.graphql
| |-application.properties

<!--  -->

src/
└── main/
└── java/
└── com/
└── medicineproject/
├── domain/
│ ├── model/
│ │ ├── Medicine.java
│ │ ├── MedicineCategory.java
│ │ └── Inventory.java
│ ├── services/
│ │ └── MedicineService.java
├── application/
│ └── services/
│ └── MedicineServiceImpl.java
├── infrastructure/
│ └── repository/
│ └── MedicineRepository.java
├── interface/
│ └── graphql/
│ └── MedicineGraphQLController.java
└── MedicineProjectApplication.java

launch.json file

{
"configurations": [
{
"type": "java",
"name": "Spring Boot-MedicalstoreApplication<medicalstore>",
"request": "launch",
"cwd": "${workspaceFolder}",
"mainClass": "com.medicalstore.medicalstore.MedicalstoreApplication",
"projectName": "medicalstore",
"args": "",
"envFile": "${workspaceFolder}/.env"
}
]
}
