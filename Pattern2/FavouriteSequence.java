import java.util.*;
public class FavouriteSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n=sc.nextInt();
            int[] bArr = new int[n];
            for(int i=0;i<n;i++)
            {
                bArr[i] = sc.nextInt();
            }

            int[] aArr=new int[n];
            int l=0,r=n-1;

            for(int i=0;i<n;i++)
            {
                if(i%2==0)
                {
                    aArr[i] = bArr[l++];
                } else {
                    aArr[i] = bArr[r--];
                }
            }
            for(int x : aArr)
            {
              System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
