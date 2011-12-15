# CS 290 Lab Six

#
# This file is part of Razza.
#
# Razza is free software: you can redistribute it and/or modify it under
# the terms of the GNU Lesser Public License as published by the Free
# Software Foundation, either version 2 of the License, or (at your option)
# any later version.

# Razza is distributed in the hope that it will be useful, but WITHOUT
# WARRANTY; without even the implied warranty of MERCHANTABILITY or
# FITNESS FOR A PARTICULAR PURPOSE.  Se the GNU Lesser Public License for
# more details.
#
# You should have received a copy of the GNU Lesser Public License along
# with Razza.  If not, see <http://www.gnu.org/licenses/>.

JFLAGS = ./junit-4.10.jar:./collection/hamcrest-all-1.3.0RC2.jar:./jumble.jar:./collection:./collection/tests:.
JC = javac
# Specifies the individual test suites to run - execute all of them by default.
TESTSUITESUBSET=""
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# Java classes to be compiled.
CLASSES = \
	collection/BubbleSort.java \
	collection/BubbleSortCompCount.java \
	collection/BubbleSortTest.java \
	collection/CountingSortAlgorithm.java \
	collection/CountingSortAlgorithmTest.java \
	collection/EQSortAlgorithm.java \
	collection/EQSortAlgorithmTest.java \
	collection/GnomeSortAlgorithm.java \
	collection/GnomeSortAlgorithmTest.java \
	collection/InsertionSortAlgorithm.java \
	collection/InsertionSortAlgorithmTest.java \
	collection/intNode.java \
	collection/LinkedQueue.java \
	collection/MergeSortComp.java \
	collection/MergeSort.java \
	collection/MergeSortTest.java \
	collection/QuickSortCount.java \
	collection/QuickSort.java \
	collection/QuickSortTest.java \
	collection/RadixSortAlgorithm.java \
	collection/RadixSortAlgorithmTest.java \
	collection/Sati.java \
	collection/ShellSortAlgorithm.java \
	collection/ShellSortTest.java \
	collection/SortAlgorithm.java \
	collection/SortItem.java \
	collection/AllTests.java 

# Remove all bytecode and the jar file.
clean:
	$(RM) -r collection/*.class
	$(RM) -r collection/tests/*.class
	$(RM) -r *.class
	$(RM) SAT.jar

# Run the JUnit test suite.
test:
	@java -classpath ./junit-4.10.jar:./collection/hamcrest-all-1.3.0RC2.jar:./collection:. AllTests $(TESTSUITESUBSET)

# Compile all of the source code.
compile:
	
	@javac -classpath ./junit-4.10.jar:./collection/hamcrest-all-1.3.0RC2.jar:./collection/tests:.  ./collection/*.java 
	
jumble:
	
	
	@javac -classpath ./junit-4.10.jar:./hamcrest-all-1.3.0RC2.jar:./jumble.jar:./collection:./collection/tests:.  ./collection/*.java
	
	
	
	@java -jar jumble.jar --classpath=$(JFLAGS) BubbleSort
	@java -jar jumble.jar --classpath=$(JFLAGS) CountingSortAlgorithm
	@java -jar jumble.jar --classpath=$(JFLAGS) EQSortAlgorithm
	@java -jar jumble.jar --classpath=$(JFLAGS) GnomeSortAlgorithm
	@java -jar jumble.jar --classpath=$(JFLAGS) InsertionSortAlgorithm
	@java -jar jumble.jar --classpath=$(JFLAGS) MergeSort
	@java -jar jumble.jar --classpath=$(JFLAGS) QuickSort
	@java -jar jumble.jar --classpath=$(JFLAGS) RadixSortAlgorithm
	@java -jar jumble.jar --classpath=$(JFLAGS) ShellSort
	
	
# Create a jar file containing all of the bytecode.
jar:
	@jar cvf SAT.jar ./build/classes

# Run the CLOC tool in order to gather program information.
cloc:
	@tools/cloc_script.txt

# Run Cobertura in order to collect coverage information.
cobertura:
	@bash ./tools/cobertura-1.9.4.1/cobertura-instrument.sh --destination ./build/instrumented ./build/classes
	@java -cp ./tools/cobertura-1.9.4.1/cobertura.jar:./build/instrumented:./build/classes:./lib/junit-4.9.jar:./lib/hamcrest-all-1.3.0RC2.jar:. -Dnet.sourceforge.cobertura.datafile=./cobertura.ser tests.AllTests
	@bash ./tools/cobertura-1.9.4.1/cobertura-report.sh --format html --datafile ./cobertura.ser --destination ./reports/cobertura ./src
