ScriptRunner 
------------------------------------------------------------------

This Java application demonstrates running JavaScript and Python code from Java
using the javax.script API. It supports Graal.js for JavaScript and Jython for Python.

REQUIREMENTS:
-------------
1. Java 11 or higher
2. External libraries (place in 'lib/' folder):
   - graal-sdk.jar
   - js-scriptengine.jar
   - truffle-api.jar
   - icu4j.jar
   - jython-standalone.jar

DOWNLOAD LINKS:
---------------
- GraalVM JavaScript:
  https://github.com/oracle/graaljs

- ICU4J:
  https://github.com/unicode-org/icu

- Jython:
  https://www.jython.org/downloads.html

USAGE:
------
1. Compile:
   javac -cp "lib/*" ScriptRunner.java -d target

2. Run:
   java -cp "target;lib/*" ScriptRunner

This will:
- Print classpath info
- List all detected scripting engines
- Evaluate JavaScript expressions using Graal.js
- Evaluate Python expressions using Jython

## outpus:

![image](https://github.com/user-attachments/assets/40d6a70c-f326-4f61-ac95-c5605d487d2b)
