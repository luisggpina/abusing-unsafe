import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class API {

	static class C {
        static long l;
		int    i;
	}

	public static void main(String[] args) throws Throwable {
        C.l = 42;

		C c = new C();
		c.i = 10;

        C arr[] = { new C(), new C() };

		Unsafe u = UnsafeUtils.getUnsafeReflection();

		Field i = C.class.getDeclaredField("i");
		long offset_i = u.objectFieldOffset(i);
		System.out.println("i: " + u.getInt(c,offset_i));

		Field l = C.class.getDeclaredField("l");
		long offset_l = u.staticFieldOffset(l);
        Object static_base_c = u.staticFieldBase(l);
		System.out.println("l: " + u.getLong(static_base_c,offset_l));

        long arr_base  = u.arrayBaseOffset(arr.getClass());
        long arr_scale = u.arrayIndexScale(arr.getClass());
		System.out.println("arr[0]: " + u.getObject(arr,arr_base + 0*arr_scale));
		System.out.println("arr[1]: " + u.getObject(arr,arr_base + 1*arr_scale));
	}
}
