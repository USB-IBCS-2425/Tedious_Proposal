import java.util.*;

class student{

	private int rafNum;
	private String name;

	public studnet(String n){
		name=n;
		rafNum=(int)(Math.random()*10001);
	}

	public int getrafNum(){
		return this.rafNum;
	}

	public String getname(){
		return this.name;
	}

	public student(String name, int rafNum){
		this.name = name;
		this.rafNum = rafNum;
}
		

class Raffle {
	//we need two arrays
	student[] sArr;
	int[] rafNums;

	public Raffle(student[] s){
		sArr=s;
		//need to create a empty array of integers first
		rafNum = new int[s.length]; //samelength

		for (int i =0; i<sArr.length; i++){
			rafNums[i]=sArr[i].getNum();

		}
	}

	public void printRaf(){
		for (int n : rafNums) {
			System.out.println(n);

		}
	}

	public Student getWinner() {
		int choice = (int)(Math.random()*5);


		return sArr[choice];
	}






}

class Pset4{
	public static void main(String[] args) {
	student p1 = new student("p1", 1234);
	student p2 = new student("p2", 2334);
	student p3 = new student("p3", 3254);
	student p4 = new student("p4", 4224);
	student p5 = new student("p5", 5534);
	student p6 = new student("p6", 6239);
	student p7 = new student("p7", 7834);
	student p8 = new student("p8", 8234);
	student p9 = new student("p9", 9234);
	student p10 = new student("p10", 9934);

	student[] s = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

	Raffle r = new Raffle(s);
	r.printRaf();
	student win = r.getWinner();
	System.out.println(win.get)


	}
}
	
