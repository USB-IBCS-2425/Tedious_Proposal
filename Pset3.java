class Wallet{
	private int money;
	private int IDnumber;

	Wallet(){
		int money = 0;
		int IDnumber = 0;
	}

	Wallet(int money, int IDnumber){
		this.money = money;
		this.IDnumber = IDnumber;


	}

	public void setmoney(int n) {
		this.money = n;
	}

	public void setIDnumber(int i){
		this.IDnumber = i;
	}

	public int getmoney() {
		return this.money;
	}

	public int IDnumber(){
		return this.IDnumber;
	}

	public void payday(int a){
		money = money + a;
	}
	public void pay(int b){
		money = money - b;
	}

public static void main(String[] args) {
		Wallet p1 = new Wallet();
		p1.setmoney(500);
		p1.setIDnumber(253);
		System.out.println(p1.getmoney());
		p1.payday(50);
		System.out.println(p1.getmoney()); 
}


}

class Shape {
	double area;

	public double getarea(){
		return area;

	}

}
class Rectangle extends Shape {
	double length;
	double width;

	public Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	public double getarea(){
		return length * width;
	}

}
class Circle extends Shape {
	double radius;

	public Circle(double radius){
		this.radius = radius;
	}

	public double radius(){
		return radius*radius*3.142;
	}

	public static void main(String[] args) {
		
		Rectangle rectangle1 = new Rectangle(5,8);
		Circle circle1 = new Circle(3);
		System.out.println(rectangle1.getarea());
		System.out.println(circle1.getarea());
	}

}

