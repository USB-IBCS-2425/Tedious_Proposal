import java.util.Arrays;
class LoopArrayPractice2{

	public static int roleDice(int x) {
		int [] returnArray = new int[x];
		for (int i=0; i < x; i++){
			returnArray[i]=x-i;

		}
		int z = (int)(Math.random()*x);
		return returnArray[z];

	}
	public static int luckyDice(int x){
		int[] returnArray = new int[x];
		for (int i=0; i <= x; i++){
			returnArray[i]= i+1;

		}
		int z = (int)(Math.random()*x);
		int z2 = (int)(Math.random()*x);

		if (returnArray[z]>returnArray[z2]) {
			return returnArray[z];
		} else {
			return returnArray[z2];
		}

	}

	public static boolean evenOrOdd(int[] x){
		int even = 0;
		int odd = 0;
		for (int i=0; i< x.length; i++) {
			if (x[i]%2 == 0){
				even++;
			} else{
				odd++;
			}
		}
		if (even==odd){System.out.println("equal amount of evens and odds");}
		return (even >= odd);


		}
		public static String[] nickName(String[] x){
			String [] ret = new String[x.length];
			for (int i=0; i < x.length; i++){
				int z = (int)(Math.random()*(x[i].length()));
				int y = (int)(Math.random()*(x[i].length()));
				if (z>y){
					ret[i] = x[i].substring(y, z);
				} else if (z<y){
					ret[i] = x[i].substring(z, y);

				} else {
					ret[i] = String.valueOf(x[i].charAt(y)); //string.value cast character into string, any other way?

				}

			}
			return ret; 


		}

		public static boolean isPalindrome(String x){

			boolean returnValue = false;

			String[] y = x.split("");
			String [] ry = new String [y.length];
			int a = 0;
			int b = 1;
			while ((ry.length-b)>=(0+a)){
				y[0+a] = ry[ry.length - b];
				a++;
				b++;
			}

			if(Arrays.equals(y,ry)){ //any other way to do array comparison?
				returnValue = true;
			}

			return returnValue;

			
		}

		public static void main(String[] args) {

			int test1 = 12;
			for (int i=0; i<10; i++){
				int result1 = roleDice(test1); 
				System.out.println(result1);
			}


			int test2 = 12;
			for (int i=0; i<10; i++){
				int result2 = roleDice(test1); 
				System.out.println(result2);
			}

			int [] test3 = {1,3,5,6,7};
			System.out.println(evenOrOdd(test3));
			String [] test4 = {"Zack", "Tom", "Ben", "James"};
			System.out.println(nickName(test4)); // how to return a array

			System.out.println(isPalindrome("racecar")); //doesnt work as intended



			




			
		}




	}





