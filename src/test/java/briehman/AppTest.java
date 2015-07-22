package briehman;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class AppTest
{
    @Test
    public void checkMethodCount() {
        List<Method> filtered = new ArrayList<>();
        for (Method m : B.class.getMethods()) {
            if (m.getDeclaringClass().getPackage() == A.class.getPackage()) {
                filtered.add(m);
            }
        }

        assertEquals(2, filtered.size());
    }

    /** This test fails under Java 7 with version <= 1.7.0_79 where the bridge method does
     *  not contain the annotation definition.
     */
    @Test
    public void checkAnnotationCount() {
        List<Method> filtered = new ArrayList<>();
        for (Method m : B.class.getMethods()) {
            if (m.getDeclaringClass().getPackage() == A.class.getPackage()) {
                assertTrue("Both the bridged and non-bridged methods contain the annotation definition in later Java versions but yours does not",
                        m.isAnnotationPresent(briehman.TestAnnotation.class));
            }
        }
    }
}
