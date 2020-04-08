# Miloqeev Test Automation Framework
Repository How-To
- Preconditions: Java IDE like Intellij or Eclipse should be installed on the environment to run tests. 
  1. Open a terminal on your personal environment
  2. Clone Repository using "git clone <url>"
  3. Move to cloned repository "cd <repository name>"
  4. Open repository with IDE as a new project
  5. Create feature file for your test
    * @Tag
        1. Feature: <Feature name>
            * Scenario: "Scenario name"
              * Given "Preconditions"
              * When "Something happens"
              * And "Something else may happen"
              * Then "Expected result to be verified"
  6. Generate test steps as Java class
  7. Create test runner
  8. Create test config file
  9. Execute test
  10. Check results in folder
  
  To execute from console:
  Open command promt
  Go to project root
  Execute mvn -pl '!miloqeev-reports, !miloqeev-framework, !miloqeev-page-objects' test -DtestFile='<testName>'
