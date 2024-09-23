class Pset2 {
	public static void main(String[] args) {
		String name = "Zion";
		String date = "Sep 8th";
		System.out.println(name);
		System.out.print(date);
		System.out.println();
		System.out.println();
		int number_students=12;
		//remember: to set a variable, using = but not :
		System.out.println(number_students + " students are in our class");
		System.out.println("A new student is enrolled in the class!");
		number_students += 1;
		System.out.println(number_students + " students are in our class");

		if (number_students >4){
			System.out.println("class is canceled");

		} else {
			System.out.println("class will continue");

		}
		int number_characters = 4;
		number_students = number_students - number_characters;
		if (number_students >4){
			System.out.println("class is canceled");

		} else {
			System.out.println("class will continue");
		}
		boolean equal = (number_students % 3 == 0);
		// == means whether if it is equal or not
		if (equal) {
			System.out.println("true " + (number_students/3));

		} else {
			int need = 3 - (number_students % 3);
			System.out.println("false" + need);
		}








		
	}



}