import java.util.Scanner;




public class AllSorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        //qs obj=new qs();
        //hs obj=new hs();
        //ms obj=new ms();
        //bs obj=new bs();
        is obj=new is();
        //ss obj=new ss();
        obj.sort(a);
        for (int x:a) {
            System.out.print(x+" ");
        }
    }
}

class bs{

    public void sort(int[] a) {
        int n=a.length;
        for (int i = 0; i <n-1 ; i++) {
            boolean swapped=false;
            for (int j = 0; j <n-1-i ; j++) {
                if(a[j]>a[j+1]){
                    swapped=true;
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
            if(!swapped) break;
        }
    }
}

class is{

    public void sort(int[] a) {
        int n=a.length;
        for (int i = 1; i <n; i++) {
            int tmp=a[i];
            int j=i-1;
            while(j>=0 && a[j]>tmp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=tmp;
        }

    }
}

class ss{
    public void sort(int[] a) {
        int length = a.length;
        for(int i = 0; i< length -1; i++){
            int si=i;
            for(int j = i+1; j< length; j++){
                if(a[j]<a[si]){
                    si=j;
                }
            }
            int tmp=a[i];
            a[i]=a[si];
            a[si]=tmp;
        }
    }
}
class ms{

    public void sort(int[] a) {
        msort(a,0,a.length-1);
    }

    private void msort(int[] a, int l, int r) {
        if(l>=r) return;
        int m=l+(r-l)/2;
        msort(a,l,m);
        msort(a,m+1,r);
        merge(a,l,m,r);
    }

    private void merge(int[] a, int l, int m, int r) {
        int s1=m-l+1;
        int s2=r-m;
        int t1[]=new int[s1];
        int t2[]=new int[s2];
        for (int i = 0; i <s1 ; i++) {
            t1[i]=a[l+i];
        }
        for (int i = 0; i <s2 ; i++) {
            t2[i]=a[m+i+1];
        }
        int i=0,j=0,k=l;
        while(i<s1 && j<s2){
            if(t1[i]<=t2[j]){
                a[k]=t1[i++];
            }else{
                a[k]=t2[j++];
            }
            k++;
        }
        while(i<s1){
            a[k]=t1[i];
            k++;
            i++;
        }
        while(j<s2){
            a[k]=t2[j];
            k++;
            j++;
        }
    }
}


class hs{

    public void sort(int[] a) {
        build(a);
        for(int i=a.length-1;i>0;i--){
            int tmp=a[i];
            a[i]=a[0];
            a[0]=tmp;
            heapify_(a,0,i);
        }
    }

    private void build(int[] a) {
        int n=a.length;
        for (int i = n/2; i>=0; i--) {
            heapify_(a,i,a.length);
        }
    }

    private void heapify_(int[] a, int i,int n) {
        int l=2*i+1;
        int r=2*i+2;
        int le=i;
        if(l<n && a[l]>a[le]) le=l;
        if(r<n && a[r]>a[le]) le=r;
        if(le!=i){
            int tmp=a[i];
            a[i]=a[le];
            a[le]=tmp;
            heapify_(a,le,n);
        }
    }
}


class qs{

    public void sort(int[] a) {
        qsort(a,0,a.length-1);
    }

    private void qsort(int[] a, int l, int r) {
        if(l>=r) return;
        int x=part(a,l,r);
        qsort(a,l,x-1);
        qsort(a,x+1,r);
    }

    private int part(int[] a, int l, int r) {
        int i=l-1,j=l;
        while(j<r){
            if(a[j]>a[r]){
                j++;
            }else{
                i++;
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                j++;
            }
        }
        int tmp=a[i+1];
        a[i+1]=a[r];
        a[r]=tmp;
        return i+1;
    }

}