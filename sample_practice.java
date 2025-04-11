import java.util.*;

class sample_practice {
	

public static int countOdd(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) count++;
        }
        return count;
    }

    public static float secondLargest(float[] arr) {
        if (arr.length < 2) return 0;
        float largest = -9999, second = -9999;
        for (float num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }
        if (second == -9999) {
    		return 0;
		} else {
    		return second;
		}
    }

    public static String[] shiftX(String[] arr, int x) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i + x] = arr[i];
        }
        return result;
    }


    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }


    public static boolean noRepeat(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) return false;
            seen.add(c);
        }
        return true;
    }


    public static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : arr) sum += num;
        return total - sum;
    }