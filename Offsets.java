import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class Offsets {

	static class C {
        static long s;
		int    i;
		long   l;
		Object o;
		Object m;
	}

	public static void main(String[] args) throws Throwable {
		Unsafe u = UnsafeUtils.getUnsafeReflection();

        int[] arr = new int[0];

		Field i = C.class.getDeclaredField("i");
		Field l = C.class.getDeclaredField("l");
		Field o = C.class.getDeclaredField("o");
		Field m = C.class.getDeclaredField("m");
		Field s = C.class.getDeclaredField("s");

		long offset_i = u.objectFieldOffset(i);
		long offset_l = u.objectFieldOffset(l);
		long offset_o = u.objectFieldOffset(o);
		long offset_m = u.objectFieldOffset(m);
		long offset_s = u.staticFieldOffset(s);
		long arr_base  = u.arrayBaseOffset(arr.getClass());
		long arr_scale = u.arrayIndexScale(arr.getClass());

		System.out.println("offset_i:  " + offset_i);
		System.out.println("offset_l:  " + offset_l);
		System.out.println("offset_o:  " + offset_o);
		System.out.println("offset_m:  " + offset_m);
		System.out.println("offset_s:  " + offset_s);
		System.out.println("arr_base:  " + arr_base);
		System.out.println("arr_scale: " + arr_scale);
	}
}
