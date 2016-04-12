package com.xxx.car.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.Eval;
import groovy.util.GroovyScriptEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class GroovyTest {
	
	public static File file = new File("/Users/zhaiyuyong/Documents/workspace/car-ental/src/main/java/com/xxx/car/groovy/scripts/UserServiceImpl.groovy");

	public static void main(String[] args) throws Exception {
		//m1();
		m2();
		//m3();
		//m4();
		//m5();
		//m6();
	}
	
	public static void m1() throws Exception{
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("groovy");
	    Reader reader = new FileReader(file);
	    Class clz =  (Class) scriptEngine.eval(reader);
	    Object obj = clz.newInstance();
	    UserService userService = (UserService) clz.newInstance();
	    userService.test();
	}
	public static void m2() throws Exception{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
		Class groovyClass = groovyCl.parseClass(file);
		System.out.println(groovyClass.newInstance().getClass());
		Object aScript = groovyClass.newInstance();
		UserService userService = (UserService) aScript;
		userService.test();
	}
	
	public static void m3() throws Exception{
		InputStream is = new FileInputStream(file);
		InputStreamReader isReader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isReader);
		String s = "";
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			System.out.println("sssss->"+s);
			sb.append(s);
		}
		GroovyShell shell = new GroovyShell();
		Script script = shell.parse(sb.toString());
		Object aScript = script.run();
		UserService userService = (UserService) aScript;
		userService.test();
	}
	
	public static void m4()throws Exception{
		String[] roots  =   new  String[]  {  "/Users/zhaiyuyong/Documents/workspace/car-ental/src/main/java/com/xxx/car/groovy/scripts"  } ;
		GroovyScriptEngine gse  =   new  GroovyScriptEngine(roots);
		Binding binding  =   new  Binding();
		Class groovyClass = gse.loadScriptByName("UserServiceImpl.groovy");
		System.out.println(groovyClass.getClass());
		Object aScript = groovyClass.newInstance();
		UserService userService = (UserService) aScript;
		userService.test();
		//Object obj = gse.run( "UserServiceImpl.groovy" , binding);
		//System.out.println(obj.getClass());
	}
	public static void m6()throws Exception{
		String[] roots  =   new  String[]  {  "/Users/zhaiyuyong/Documents/workspace/car-ental/src/main/java/com/xxx/car/groovy/scripts"  } ;
		GroovyScriptEngine gse  =   new  GroovyScriptEngine(roots);
		Binding binding  =   new  Binding();
		Object obj = gse.run( "UserServiceImpl.groovy" , binding);
		System.out.println(obj.getClass());
	}
	
	public static void m5()throws Exception{
		InputStream is = new FileInputStream(file);
		InputStreamReader isReader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isReader);
		String s = "";
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			System.out.println("sssss->"+s);
			sb.append(s);
		}
		Eval.me(sb.toString());
	}
}
