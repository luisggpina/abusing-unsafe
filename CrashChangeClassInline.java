import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class CrashChangeClassInline {

	public static void main(String[] args) throws Throwable {
        if (args.length == 0)
            crash();
        else
            notcrash();
	}

    // m is to account for padding in A
	static class A { int m; long   l; void method() { throw new Error(); } }
	static class B { int m; int  i,j; void method() { } }

    public static void crash() {
        while (true) {
            A a = new A();
            a.l = Long.MAX_VALUE;

            B b = new B();
            Unsafe u = UnsafeUtils.getUnsafeReflection();

            int b_klass = u.getInt(b,8L);

            u.putInt(a,8L,b_klass);

            a.method();
        }
    }

    public static void notcrash() {
        while (true) {
            A a = new A();
            a.l = Long.MAX_VALUE;

            B b = new B();

            B aa = (B)changeClassWithoutInlining(a,b);

            aa.method();
        }
    }

    public static Object changeClassWithoutInlining(Object target, Object source) {
        Unsafe u = UnsafeUtils.getUnsafeReflection();

        int source_klass = u.getInt(source,8L);

        u.putInt(target,8L,source_klass);
        // Huge method doesn't get inlined
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);
        u.putInt(target,8L,source_klass);

        return target;
    }
}
