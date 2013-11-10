package two.srcerror.util;

public class Vector {
	public static final Vector zero = new Vector(0, 0, 0, 0);
	private float x, y, z, w;

	public Vector(float x) {
		this(x, 0f);
	}

	public Vector(float x, float y) {
		this(x, y, 0f);
	}

	public Vector(float x, float y, float z) {
		this(x, y, z, 0f);
	}

	public Vector(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public float getX() {
		return x;
	}

	public float getR() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getG() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getB() {
		return z;
	}

	public float getW() {
		return w;
	}

	public float getA() {
		return w;
	}

	public boolean isZero() {
		return (x == y && y == z && z == w && w == 0);
	}

	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y, z + v.z, w + v.w);
	}

	public Vector sub(Vector v) {
		return new Vector(x - v.x, y - v.y, z - v.z, w - v.w);
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!o.getClass().equals(Vector.class))
			return false;
		Vector v = (Vector) o;
		return comparef(v.x, x) && comparef(v.y, y) && comparef(v.z, z) && comparef(v.w, w);
	}

	private static boolean comparef(float a, float b) {
		return (a - .1 < b && a + .1 > b);
	}

	public float[] asFloatArray(int n) {
		float vec[] = new float[n];
		switch (n) {
			case 4:
				vec[0] = x;
				vec[1] = y;
				vec[2] = z;
				vec[3] = w;
			case 3:
				vec[0] = x;
				vec[1] = y;
				vec[2] = z;
			case 2:
				vec[0] = x;
				vec[1] = y;
			case 1:
				vec[0] = x;
			default:
				vec = null;
		}
		return vec;
	}
}