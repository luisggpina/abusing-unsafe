import java.lang.reflect.Field;
import java.util.LinkedList;

import sun.misc.Unsafe;

public class CrashChangeClassSize {

	static class A { long l  ,m  ,n  ; }
	static class B { int  i,j; }

    public static void main(String[] args) {
        LinkedList bs = new LinkedList();
        while (true) {
            A a = new A();
            B b = new B();
            Unsafe u = UnsafeUtils.getUnsafeReflection();

            int b_klass = u.getInt(b,8L);

            u.putInt(a,8L,b_klass);
            bs.add(a);
        }
    }
}
