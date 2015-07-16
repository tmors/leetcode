package geo_shape;

public class Triangle extends Getmitric{
	float a,b,c,p;
	
	public double area() {
		// TODO Auto-generated method stub
		
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	public double peri() {
		// TODO Auto-generated method stub
		return this.p;
	}

	public Triangle(float a, float b, float c) {
	
		this.a = a;
		this.b = b;
		this.c = c;
		this.p = (a+b+c)/2;
	}
	
	
	
}
