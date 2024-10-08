class ChompBistro{
	String[]employees = 5;
	String[]possibleMenu = 5;
	int dayOfWeek;

	public ChompBistro(String[]employees, String[]possibleMenu, int dayOfWeek){
		this.employees = employees;
		this.possibleMenu = possibleMenu;
		this.dayOfWeek = dayOfWeek;
	}



	public String getEmployees(){
		String returnString = employees[0]+ employees[1]+ employees[2]+ employees[3]+ employees[4];
		return returnString; 




	}
	public String getMenuItems(){
		String returnString = possibleMenu[0]+ possibleMenu[1]+ possibleMenu[2]+ possibleMenu[3]+ possibleMenu[4];
		return returnString;


	}

	public int getDay(){
		return dayOfWeek;

	}

	public void setDay(int x){
		dayOfWeek = x; 

	}
	public static void main(String[] args) {
		
	}


}