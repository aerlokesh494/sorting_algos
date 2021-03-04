import java.util.Scanner;

public class QuickSortProgram {

    void qsort(int[] arr,int l,int r){
        if(l>=r) return;
        int pi=partition(arr,l,r);
        qsort(arr,l,pi-1);
        qsort(arr,pi+1,r);
    }

    int partition(int[] arr, int l, int r) {
        int i=l-1;
        while(l<r){
            if(arr[l]<arr[r]){
                i++;
                swap(arr,i,l);
            }
            l++;
        }
        swap(arr,i+1,r);
        return i+1;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printarray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        QuickSortProgram quickSortProgram=new QuickSortProgram();
        quickSortProgram.qsort(arr,0,n-1);
        printarray(arr);
    }
}
