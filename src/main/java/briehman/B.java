package briehman;

public class B extends A {
    @Override
    @TestAnnotation(name="Specific method")
    public Specific method() {
        return null;
    }
}
