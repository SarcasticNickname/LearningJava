package basics;

import java.util.Random;

public class Vector {
	
	static final Random rnd = new Random();
	
	private int x;
	private int y;
	private int z;
	
	static Vector [] createRandomVectors(int N) {
		assert(N>0);
		Vector [] vectors = new Vector[N];
		for(int i = 0; i < N; i++) {
			vectors[i] = new Vector(rnd.nextInt(1000),rnd.nextInt(1000),rnd.nextInt(1000));
		}
		return vectors;
	}
	
	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public double length() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public double innerProduct(Vector another) {
		return another.x * x + another.y * y + another.z;
	}
	
	public Vector crossProduct(Vector another) {
		int xParam = y * another.getZ() - z * another.getY();
		int yParam = z * another.getX() - x * another.getZ();
		int zParam = x * another.getY() - y * another.getX();
		return new Vector(xParam,yParam,zParam);
	}
	
	public double angle(Vector another) {
		return Math.acos((innerProduct(another))/(length()*length())) * 180 / Math.PI;
	}
	
	public Vector add(Vector another) {
		return new Vector(x + another.getX(),
						  y + another.getY(),
						  z + another.getZ());
	}
	
	public Vector subtract(Vector another) {
		return new Vector(another.getX() - x,
						  another.getY() - y,
						  another.getZ() - z);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	@Override
	public String toString() {
		return "X: " + x + " Y: " + y + " Z:" + z;
	}
	
	public static void main(String [] args) {
		Vector[] vectors = Vector.createRandomVectors(10);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].innerProduct(vectors[1]));
        System.out.println(vectors[0].crossProduct(vectors[1]));
        System.out.println(vectors[0].angle(vectors[1]));
        System.out.println(vectors[0].add(vectors[1]));
        System.out.println(vectors[0].subtract(vectors[1]));
	}
}
