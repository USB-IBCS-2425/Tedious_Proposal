class LoopArrayPractice2{

	public static int roleDice(int x) {
		int [] returnArray = x;
		for (i=0; i <= x; i++){
			returnArray[i]= i +1

		}
		int z = int (Math.random()*x);
		return returnArray[z];

	}
	public static int luckyDice(int x){
		int[] returnArray = x;
		for (i=0; i <= x; i++){
			returnArray[i]= i +1

		}
		int z = int (Math.random()*x);
		int z2 = int (Math.random()*x);

		if (returnArray[z]>returnArray[z2]) {
			return returnArray[z];
		} else {
			return returnArray[z2];
		}

	}

	public static int evenOrOdd(int[] x){
		int even = 0;
		int odd = 0;
		for (i=0; i< x.length; i++) {
			if (x[i]%2 == 0){
				even++;
			} else{
				odd++;
			}
		}
		if (even==odd){System.out.println("equal amount of evens and odds");}
		return (even >= odd);


		}
		public static String nickName(String[] x){




		}

		public static String isPalindrome(String x){
			
		}




	}





