import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class ChangeClass {

    // m is to account for padding in A
	static class A { int m; long   l; }
	static class B { int m; int  i,j; }

	public static void main(String[] args) throws Throwable {
        A a = new A();
        a.l = Long.MAX_VALUE;

        System.out.println(a.getClass().getName());
        System.out.println(a.l);

		Unsafe u = UnsafeUtils.getUnsafeReflection();

        B b = new B();
        int b_klass = u.getInt(b,8L);

        u.putInt(a,8L,b_klass);

        System.out.println(a.getClass().getName());
        System.out.println(((B)(Object)a).i);
        System.out.println(((B)(Object)a).j);

	}
}
