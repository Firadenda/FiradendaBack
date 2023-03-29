# FiradendaBack

# Cloning and launching a Spring Boot project with Corretto 18 in IntelliJ IDEA

## Prerequisites

- IntelliJ IDEA installed on your machine.
- Corretto 18 JDK installed on your machine.
- Maven installed on your machine and configured to use Corretto 18.

## Steps

1. Clone the Spring Boot project from GitHub using the following command in your terminal:  git clone https://github.com/Firadenda/FiradendaBack.git

2. Open IntelliJ IDEA and select "Open" from the "File" menu.

3. Navigate to the root directory of the cloned project and select it.

4. Wait for IntelliJ IDEA to finish loading the project.

5. Set up your JDK in IntelliJ IDEA:

- Open the "Project Structure" dialog by selecting "Project Structure" from the "File" menu.
- Click the "Project" tab on the left.
- Under "Project SDK", click the "New" button and select "JDK".
- Navigate to the directory where Corretto 18 is installed on your machine and select it.
- Click "OK" to close all windows.

6. Set up your Maven path in IntelliJ IDEA:

- Open the "Preferences" dialog by selecting "Preferences" from the "IntelliJ IDEA" menu on macOS, or "File" > "Settings" on Windows and Linux.
- Search for "Maven" in the search box.
- Click "Maven" under "Build, Execution, Deployment".
- In the "Maven home directory" field, enter the path to your Maven installation directory.
- Click "OK" to close all windows.

7. Sync Maven by clicking the "Reload All Maven Projects" button in the Maven toolbar.

8. Build the project by selecting "Build" from the "Build" menu.

9. Run the project by selecting the main class that contains the `main` method and clicking the green "Run" arrow button in the gutter next to it.

Congratulations, you have successfully cloned and launched a Spring Boot project with Corretto 18 in IntelliJ IDEA!
