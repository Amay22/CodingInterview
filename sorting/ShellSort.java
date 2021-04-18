package sorting;


public class ShellSort {

    public static int[] shell_sort(int[] arr) {
        int increment = arr.length / 2;
		while (increment > 0) {
			for (int i = increment; i < arr.length; i++) {
				int j = i;
				int temp = arr[i];
				while (j >= increment && arr[j - increment] > temp) {
					arr[j] = arr[j - increment];
					j = j - increment;
				}
				arr[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
       	return arr;
    }


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = shell_sort(arr);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
