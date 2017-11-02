# Brackets

# Description

The program reads strings from standard input and determines if they are well formatted according to the rules specified in "readme.pdf".
Code to read from a file instead of stdin is already in place, and can be un-commented if needed.

# Running the program

Run the program from the Command Line<br/>
1- Navigate to [$PROJECT_HOME]/src/main/java<br/>
2- Compile the main class: javac Main.java<br/>
3- Run the class file: java Main<br/><br/>

Run from an IDE (I used IntelliJ)<br/>
1- Import and configure the Maven project<br/>
2- Run Main.java<br/>
3- You can also run the Tests class.

# Known Issue
My code flags the input "[(){}]" as true ,i.e.: well formed, while the provided "results.txt" is showing a result of false.
I had to commit the code with this known issue because of the time constraint, and because I'm not entirely sure which rule(s) this input actually breaks.
