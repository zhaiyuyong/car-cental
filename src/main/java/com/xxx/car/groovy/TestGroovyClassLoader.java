package com.xxx.car.groovy;

import java.io.IOException;

import groovy.lang.GroovyClassLoader;

public class TestGroovyClassLoader {
	static GroovyClassLoader loader = new GroovyClassLoader(); 

	// see if the number of loaded class keeps growing when  
    // using GroovyClassLoader.parseClass  
    public static void test() {  
         
        String scriptText = "package com.xxx.car.groovy;\n public class Foo {\n"  
            + "  int add(int x, int y) { x + y }\n"  
            + "}\n"
            + "class MyClass {}"; 
        String scriptText2 = "class Zhaiyuyong {\n"  
                + "  int add(int x, int y) { x + y }\n"  
                + "}";
  
        Class<?> clazz = null;
        int i=0;
        while (true) {  
        	Class<?> newClazz = null;
        	if(i%2==0){
        		newClazz = loader.parseClass(scriptText); 
        	}else {
        		newClazz = loader.parseClass(scriptText2); 
        	}
            System.out.println("+++"+newClazz.getClassLoader().getClass());
            if (clazz == newClazz) {  
                System.out.println("class cached");  
                break;  
            }  
            clazz = newClazz;
            i++;
            System.out.println("index--->"+i);
            if(i==1000){
            	//System.gc();
                System.out.println("GC over");
                break;
            }
        }  
        try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loader = null; 
        clazz = null;
        
    }  
      
    public static void main(String[] args) {  
        test();  
    }  
}
