import java.lang.reflect.Field;

import java.util.LinkedList;

import sun.misc.Unsafe;

public class ChangeHashCode {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        assert(a.hashCode() != b.hashCode());

		Unsafe u = UnsafeUtils.getUnsafeReflection();
        System.out.println(u.getInt(a,1L));
        assert(a.hashCode() == u.getInt(a,1L));

        u.putInt(b,1L,a.hashCode());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        assert(a.hashCode() == b.hashCode());
    }
}
