import java.util.Scanner;

public class HeapSort {
    private void heapify(int[] arr, int n, int i) {
        int ln=i;
        if(2*i+1<n && arr[2*i+1]>arr[ln]) ln=2*i+1;
        if(2*i+2<n && arr[2*i+2]>arr[ln]) ln=2*i+2;
        if(ln!=i){
            swap(arr,i,ln);
            heapify(arr,n,ln);
        }
    }
    private void swap(int[] arr, int i, int j) {
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];
    }
    public void sort(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        HeapSort heapSort=new HeapSort();
        heapSort.sort(arr);
        printarray(arr);
    }

    private static void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}

