# Joke API Test Automation Framework

This project is an automated test framework for the **Official Joke API**. It is developed in **Java 17** using **Maven**, **Cucumber**, and **RestAssured**, and it allows testing main endpoints as well as negative scenarios of the API.

---

## 1️⃣ Prerequisites

Before running the tests, you need to install and configure the following:

### 1. Java 17

- **Why Java 17?**  
  Java 17 is a stable LTS version, fully compatible with RestAssured 5.5.5 and Cucumber 7.22.2, and widely supported in modern CI/CD pipelines.

- **Download and install:**  
  [Adoptium (OpenJDK 17)](https://adoptium.net/temurin/releases/?version=17)  
  Follow the instructions for your operating system.

  - **Verify installation:**

        java -version

    It should return something like 17.x.x

### 2. Maven

- **Why Maven?**  
  Maven is used to manage dependencies, plugins, build the project, and run tests.

- **Download and install:**

  [Maven](https://maven.apache.org/download.cgi)
  - **Verify installation:**
  
        mvn -version

    It should show Maven 3.x.x and Java 17 as the JDK.

### 3. IDE (optional but recommended)

- **[IntelIJ](https://www.jetbrains.com/idea/download/?section=windows)**
- **IDE setup:**
  
    Open the project as a Maven project

    Configure Project SDK to Java 17

    Ensure Project language level is 17


##  2️⃣ Clone the project and initial setup

1. **Clone the repository:**


        git clone https://github.com/JoseManuelGraoSoto/assesmentSantanderBankPolska.git

2. **Open the project in IntelliJ:**

    File → Open → select project folder

    IntelliJ will detect it as a Maven project automatically.


3. **Refresh Maven:**

    IntelliJ → Maven → Reload Project

    This downloads all dependencies defined in pom.xml.