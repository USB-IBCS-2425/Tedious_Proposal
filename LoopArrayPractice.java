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

	public static boolean inOrder(Int[] Array){
		boolean ascend = true;
		int count = 0;

		for (int i = 1; i < 6; i++){
			if (Array[i] => Array[i-1]){
				int count++1;
			}
			if (int count == 4){
				return boolean ascend;
			}
		}
		for (int i = 1; i < 6; i++){
			if (Array[i] =< Array[i-1]){
				int count++1;
			}
			if (int count == -4){
				boolean ascend = false;
				return boolean ascend;
			}
		}
	}

	public static String doubleLetter 




}

