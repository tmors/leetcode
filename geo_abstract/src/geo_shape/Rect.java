package geo_shape;

public class Rect extends Getmitric{
	float width,length;
	

	public float getWidth() {
	
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public Rect(float width, float length) {
		this.width = width;
		this.length = length;
	}

	public double area() {
		// TODO Auto-generated method stub
		return width*length;
	}

	public double peri() {
		// TODO Auto-generated method stub
		return 2*(width+length);
	}
	

}
