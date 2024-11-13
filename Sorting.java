import java.util.*
class Sorting {

	public static ArrayList<Integer> BubbleSort(ArrayList<Integer> aL) {
		int a = aL.size();

		for (int i = 0; i < a; i++){
			int swap = 0;
			for (int j = 0; j < aL.size - 1; j++) {
				if (aL.get(j)>aL.get(j+1)){
					aL.set(j+1,arr.get(j));
					swap++;
				}

			}
			if (swap == 0){break;}
		}
		return aL
	}

	 public static void main(String[] args) {
		
		ArrayList<Integer> test = new ArrayList<Integer>(5);
		for (int i = 0; i < 10; i++) {
			int rL = (int)(Math.random()*100);
			array.add(rL;
		}
		System.out.println(test);
		long start = System.nanoTime();
		System.out.println(BubbleSort(test);
		System.out.println( (long)(System.nanoTime()-start) + " nano seconds");
	}



}

