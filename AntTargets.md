ant clean  --  Removes the build directory and the .jar file.

ant compile --  Makes the build/classes/ directory, sets the appropriate classpath, and compiles the program.

ant run -- Runs Maxwell.

ant debug -- Runs Maxwell with verbose debugging output.

ant jar --  Creates full Maxwell.jar.

ant test -- Runs the automated JUnit tests for Maxwell.

ant prepl4j -- Prepares Launch4j with current working version data.

ant launch4j -- Packages Maxwell.jar as a windows executable (Maxwell.exe).

ant version -- Displays current working version's data.

ant ship -- Runs clean, compile, jar, prepl4j, launch4j, and then renames the product files for shipping and cleans up a little.

ant cloc --  Runs the Count Lines of Code tool.