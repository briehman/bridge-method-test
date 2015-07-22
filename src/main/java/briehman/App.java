package briehman;

import java.lang.reflect.Method;

public class App
{
    public static void main( String[] args )
    {
        for (Method m : A.class.getMethods()) {
            System.out.println(m.toString() + " - bridge? " + m.isBridge());
        }
        System.out.println("");
        for (Method m : B.class.getMethods()) {
            System.out.println(m.toString() + " - bridge? " + m.isBridge());
        }
    }
}
