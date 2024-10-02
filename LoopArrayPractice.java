class LoopArrayPractice{


	public static int middleValues(int[] Array){
		return Array[Array.length/2];
	}

	public static int numMatches(String[] Array, String p1){
		int number = 0;
		for (int i = 0; i < Array.length; i++ ){
			if (Array[i] == p1) {
				number++;
			}
		}
		return number;


	}

	public static boolean inOrder(int[] Array){
		boolean ascend = true;
		int count = 0;

		for (int i = 1; i < Array.length; i++){
			if (Array[i] >= Array[i-1]){
				count++;
			}
			
		}
		for (int i = 1; i < Array.length; i++){
			if (Array[i] <= Array[i-1]){
				count++;
			}
			if (count == Array.length-1){
				ascend = false;
				
			}
		}
		return ascend; 
		
	}

	public static boolean[] doubleLetter(String[] Array){
		boolean[] returnArray = new boolean [Array.length];
		for (int i=0; i< Array.length; i++){
			for (int a=1; a< Array[i].length();a++){
				if (Array[i].charAt(a) == Array[i].charAt(a-1)){
					returnArray[i] = true;
					break;
				}
				
			}

		}
		return returnArray;

	}

	public static String[] bookEnds(String[] Array){
		int count = 0;
		for (int i=0; i< Array.length; i++){
			if (Array[i].charAt(0)==Array[i].charAt(Array[i].length()-1)){
				count++;

			}
		}
		String[] returnArray = new String[count];
		int index = 0;
		for (int i=0; i< Array.length; i++){
			if (Array[i].charAt(0)==(Array[i].charAt(Array[i].length()-1))){
				returnArray[index] = Array[i];
				index++;

			}
		}
		return returnArray;
	}

	public static void main(String[] args) {
		//middleValues test
		int[] array1 = {1,2,3,4,5};
		System.out.println(middleValues(array1));

		//numMatches test
		String[] array2 = {"hello", "java", "world", "java"};
		String word = "java";
		System.out.println(numMatches(array2, word));

		//inOrder test
		int[] array3 = {5,4,3,2,1};
		System.out.println(inOrder(array3));

		//doubleLetter 
		String[] array4 = {"Considine", "Phillips", "Vankatesh", "Elliott", "Droubay", "Woolley"};
		boolean[] array5 = doubleLetter(array4);
		for (int i = 0; i < array5.length; i++) {System.out.print(array5[i] + " ");} //why here
		System.out.print("\n");

		//bookEnds
		String[] array6 = {"bob", "jim", "sally", "anna", "boen", "elle", "considinec"};
		String[] array7 = bookEnds(array6);
		for (int i = 0; i < array7.length; i++) {
			System.out.print(array7[i] + " "); 
		}
		System.out.print("\n"); 



}




}

