package geo_shape;

public class Circle extends Getmitric{

	/**
	 * @param args
	 */
	float radius;

	public Circle(float radius) {
		this.radius=radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public double area(){
		return radius*radius*Math.PI;
		
	}
	public double peri() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}


}
