import java.util.*;
class hanoiCount {
	static int exetime = 0;
	public static int hanoi(int mem[][], int t, int d) {
		int tmp = 0, stepCount = 0;
		if(d < t){
			return 2*d-1;
			
		}else if(t == 3) {
			return (int)Math.pow(2, d)-1;
		//查表
		}else if(mem[t][d]!=0){
			return mem[t][d];
			
		}else if (t==4) {
			//count: a1 ~ an; Power2: 2的次方
			int disk = d-3, i = 3, count = 5, Power2 = 4;
			while(disk-i >= 0) {
				exetime++ ;
				disk -= i;
				count += Power2*i;
				i++;
				Power2 *= 2;
			}
			count += disk*Power2;
			mem[t][d] = count;
			return count;
		}else {
			for(int mid=d-1 ; mid>=t-2 ; mid--) {
				//計算執行幾次(時間複雜度估算)
				exetime++;
				if(mid == d-1) {
					stepCount = hanoi(mem, t,d-mid)*2 + 
							hanoi(mem, t-1,mid);
				}else {
					tmp = hanoi(mem, t,d-mid)*2 + 
							hanoi(mem, t-1,mid);
					if(tmp < stepCount) {
						stepCount = tmp;
					}
				}
			}
			mem[t][d] = stepCount;
			return stepCount;
		}
	}
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		//柱
		int tower = input.nextInt();
		//碟子
		int disk = input.nextInt();

		//記錄算過的值以便之後查表
		int[][] mem = new int[tower+1][disk+1];
		
		System.out.println(tower + " tower " + disk + " disk: "
				+ hanoi(mem,tower,disk));
		System.out.println("execution time: " + exetime);
		System.out.println("The hanoi table: ");
		//just to print out a part of table
		for(int i=1 ; i<tower ; i++) {
			for(int j=30 ; j<disk ; j++) {
				System.out.print(mem[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
