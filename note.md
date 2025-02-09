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
