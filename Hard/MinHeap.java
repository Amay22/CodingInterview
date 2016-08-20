package Hard;

public class MinHeap {

    public int size;
    private int[] mH;
    private int position;

    private MinHeap(int size) {
        this.size = size;
        mH = new int[size + 1];
        position = 0;
    }

    private void createHeap(int[] arrA) {
        if (arrA.length > 0) {
            for (int anArrA : arrA) {
                insert(anArrA);
            }
        }
    }

    private void display() {
        for (int i = 1; i < mH.length; i++) {
            System.out.print( mH[i]+ " ,");
        }
        System.out.println("");
    }

    private void insert(int x) {
        if (position == 0) {
            mH[position + 1] = x;
            position = 2;
        } else {
            mH[position++] = x;
            bubbleUp();
        }
    }

    private void bubbleUp() {
        int pos = position - 1;
        while (pos > 0 && mH[pos / 2] > mH[pos]) {
            swap(pos, pos/2);
            pos = pos / 2;
        }
    }

    private int extractMin() {
        int min = mH[1];
        mH[1] = mH[position - 1];
        mH[position - 1] = 0;
        position--;
        sinkDown(1);
        return min;
    }

    private void sinkDown(int k) {
        int smallest = k;
        if (2 * k < position && mH[smallest] > mH[2 * k]) {
            smallest = 2 * k;
        }
        if (2 * k + 1 < position && mH[smallest] > mH[2 * k + 1]) {
            smallest = 2 * k + 1;
        }
        if (smallest != k) {
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    private void swap(int a, int b) {
        int temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }

    public static void main(String args[]) {
        int arrA[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        System.out.print("Original Array : ");
        for (int anArrA1 : arrA) {
            System.out.print("  " + anArrA1);
        }
        MinHeap m = new MinHeap(arrA.length);
        System.out.print("\nMin-Heap : ");
        m.createHeap(arrA);
        m.display();
        System.out.print("Extract Min :");
        for (int anArrA : arrA) {
            System.out.print("  " + m.extractMin());
        }

    }
}

/*Original Array :   3  2  1  7  8  4  10  16  12
Min-Heap : 1 ,3 ,2 ,7 ,8 ,4 ,10 ,16 ,12 ,
Extract Min :  1  2  3  4  7  8  10  12 */
