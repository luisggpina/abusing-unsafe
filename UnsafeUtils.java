import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeUtils {
	public static Unsafe getUnsafe() {
        return Unsafe.getUnsafe();
    }

	public static Unsafe getUnsafeReflection() {
		try {
			Field u = Unsafe.class.getDeclaredField("theUnsafe");
			boolean accessible = u.isAccessible();
			u.setAccessible(true);
			Unsafe ret = (Unsafe) u.get(null);
			u.setAccessible(accessible);
			return ret;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new Error(e);
		}
	}

    public static void main(String[] args) {
        if (args.length == 0)
            getUnsafe();
        else
            getUnsafeReflection();
    }
}
