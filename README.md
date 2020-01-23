# Tic-Tac-Toe
Android App for user to play tic tac toe 

# Tic-Tac-Toe Development
It follow MVVM Pattern and Test-Driven Development


# Basic Understanding Of MVVM : 
it devided into 3 parts 

1. View : it contain User Interface

2. Model : where actual business logic implemented and it exposes its data to viewmodel

3. ViewModel : it will get the data from Model and generate Observable which is observe by view part  

basically ViewModel have no idea who is observing 

# Test-Driven Development (TDD) :

TDD is a software-development process. You can apply TDD wherever you practice software development, it described as Red-Green-Refactor. It’s a process in which you write the tests that specify the code you’re going to write before you start writing any of the code.

1. Instrumentation tests are for the parts of your code that are dependent on the Android framework but that do not require the UI

2. Unit test, It’s generally concerned with one class at a time, testing one function at a time. Unit tests typically run the fastest out of the different kinds of tests, because they are small and independent of the Android framework and so do not need to run on a device or emulator. JUnit is usually used to run these tests.

# App Screens : 
it contain 4 screens

1. Splash Screen 

2. Player page : take 2 player name from user

3. Main Tic Tac Toe Board page : it will generate empty board having 3 X 3 rows and collomns to play

**It also provide exit functionality if user do not want to play at any point they can exit by just tapping exit/back button two times**

4. Winner page : it will display game winner

# Screenshots :

**1** ![Alt text](/screenshot/1.png?raw=true "Splash Screen")  **2**  ![Alt text](/screenshot/2.png?raw=true "Player Page")  

===============================================================================

**3**  ![Alt text](/screenshot/3.png?raw=true "Main Tic Tac Toe Board Page")  **4**  ![Alt text](/screenshot/4.png?raw=true "Winner Page")



