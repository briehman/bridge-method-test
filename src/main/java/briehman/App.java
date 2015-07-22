package briehman;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class App
{
    public static void main( String[] args )
    {
        Class[] classes = new Class[] { A.class, B.class };
        for (Class clazz : classes) {
            for (Method m : clazz.getMethods()) {
                if (m.getDeclaringClass().getPackage() == App.class.getPackage()) {
                    System.out.println(m.toString());
                    System.out.println("  Bridge? " + m.isBridge());
                    for (Annotation a : m.getDeclaredAnnotations()) {
                        System.out.println("  Annotation: " + a);
                    }
                }
            }
            System.out.println("");
        }
    }
}
