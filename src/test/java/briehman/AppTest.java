package briehman;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class AppTest extends TestCase
{
    public void testApp()
    {
        List<Method> filtered = new ArrayList<>();
        for (Method m : B.class.getMethods()) {
            if (m.getDeclaringClass().getPackage() == A.class.getPackage()) {
                filtered.add(m);
            }
        }

        assertEquals(2, filtered.size());
    }
}
