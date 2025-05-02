
// java -cp "target;lib\*" ScriptRunner
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * A script runner that executes JavaScript and Python code using Java's scripting API.
 * This demonstrates how to evaluate simple expressions in different languages.
 */
public class ScriptRunner {

    public static void main(String[] args) {
        // Display the current classpath for troubleshooting
        printClasspathInfo();
        
        // Initialize the script engine manager
        ScriptEngineManager engineManager = new ScriptEngineManager();
        
        // Show all available scripting engines
        displayAvailableEngines(engineManager);
        
        // Test JavaScript calculations
        testJavaScriptExpressions(engineManager);
        
        // Test Python calculation
        testPythonExpression(engineManager);
    }

    /**
     * Prints the current Java classpath being used
     */
    private static void printClasspathInfo() {
        System.out.println("Current classpath: " + System.getProperty("java.class.path"));
    }

    /**
     * Displays all available script engines
     * @param manager The script engine manager instance
     */
    private static void displayAvailableEngines(ScriptEngineManager manager) {
        System.out.println("\nDetected scripting engines:");
        manager.getEngineFactories().forEach(factory -> {
            System.out.printf("- %s (aliases: %s)\n", 
                factory.getEngineName(), 
                factory.getNames());
        });
    }

    /**
     * Tests JavaScript expressions using different engine names
     * @param manager The script engine manager instance
     */
    private static void testJavaScriptExpressions(ScriptEngineManager manager) {
        // Calculate 2^10 using Graal.js engine
        evaluateExpression(manager, "graal.js", "2^10 calculation", "Math.pow(2, 10)");
        
        // Calculate 2^8 using generic JavaScript name
        evaluateExpression(manager, "javascript", "2^8 calculation", "Math.pow(2, 8)");
    }

    /**
     * Tests a simple Python expression
     * @param manager The script engine manager instance
     */
    private static void testPythonExpression(ScriptEngineManager manager) {
        evaluateExpression(manager, "python", "Simple addition", "3 + 2");
    }

    /**
     * Evaluates an expression in the specified scripting language
     * @param manager The script engine manager
     * @param engineName Name of the engine to use
     * @param description Description of the test
     * @param expression The expression to evaluate
     */
    private static void evaluateExpression(ScriptEngineManager manager, 
                                         String engineName, 
                                         String description,
                                         String expression) {
        System.out.printf("\nTesting %s (%s):\n", description, engineName);
        
        try {
            ScriptEngine engine = manager.getEngineByName(engineName);
            
            if (engine == null) {
                System.out.printf("Error: %s engine not available\n", engineName);
                return;
            }
            
            Object result = engine.eval(expression);
            System.out.printf("Result: %s\n", result);
            
        } catch (ScriptException e) {
            System.out.printf("Error evaluating %s: %s\n", 
                engineName, e.getMessage());
        } catch (Exception e) {
            System.out.printf("Unexpected error with %s: %s\n", 
                engineName, e.getMessage());
        }
    }
}