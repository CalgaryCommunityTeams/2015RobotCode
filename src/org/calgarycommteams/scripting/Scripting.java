package org.calgarycommteams.scripting;

import java.io.FileNotFoundException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Used to run javascript.
 *
 * @since March 12 15
 * @author Daniel Doran
 */
public class Scripting {

	private ScriptEngine engine;
	private Invocable engineInv;

	private Scripting() {
		ScriptEngineManager factory = new ScriptEngineManager();
		engine = factory.getEngineByName("JavaScript");
		engineInv = (Invocable) engine;
		engine.put("robot", new RobotInterface());
		engine.put("raw", new ConstantsInterface());
	}

	/**
	 * Loads and then executes a file specified
	 *
	 * @param command
	 *            path to *.js file
	 * @return the value generated by the script
	 */
	public Object load(String file) throws ScriptException {
		try {
			return engine.eval(new java.io.FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * executes the string as script
	 *
	 * @param file
	 *            javascript code to be executed
	 * @return the value generated by the script
	 */
	public Object run(String command) throws ScriptException {
		return engine.eval(command);
	}

	/**
	 * executes a specified function
	 *
	 * @param name
	 *            name of function
	 * @param args
	 *            arguments passed to the function
	 * @return the value generated by the script
	 */
	public Object invoke(String name, Object... args)
			throws NoSuchMethodException, ScriptException {
		return engineInv.invokeFunction(name, args);
	}
	
	/**
	 * sets a variable
	 *
	 * @param key
	 *            name of variable
	 * @param value
	 *            value to set the variable to
	 */
	public void put(String key, Object value) {
		engine.put(key, value);
	}
	
	/**
	 * gets the value of a variable
	 *
	 * @param key
	 *            name of variable
	 * @return the value of the variable
	 */
	public Object get(String key) {
		return engine.get(key);
	}

	/**
	 * gets the instance
	 *
	 * @return the instance
	 */
	static public Scripting getInstance() {
		return instance;
	}
	
	static private Scripting instance = new Scripting();

}
