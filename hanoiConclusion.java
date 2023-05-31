import java.util.Scanner;
class hanoiConclusion {
	static int exetime = 0;
	public static int hanoi(int d, int t) {
		if(d < t){
			return 2*d-1;
			
		}else if(t == 3) {
			return (int)Math.pow(2, d)-1;
		}else {
			int exp=4, step=hanoi(t-1, t), numerator=t-1, coef=(t-1)*(t-2)/2,
					denominator=2;
			d -= t-1;
			while(d-coef >= 0) {
				exetime++;
				//just to check disk and exp count
				System.out.println("disk:"+d+" exp:"+exp);
				d -= coef;
				step += exp*coef;
				exp *= 2;
				/*
				4!/2!2! ; 5!/3!2! 5/3
				5!/3!2! ; 6!/4!2! 6/4
				6!/4!2! ; 7!/5!2! 7/5
				*/
				numerator++;
				denominator++;
				coef = coef*numerator/denominator;
			
			}
			step += d*exp;
			return step;
		}
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		//柱
		int tower = input.nextInt();
		//碟子
		int disk = input.nextInt();
		
		System.out.println(tower + " tower " + disk + " disk: "
				+ hanoi(disk,tower));
		System.out.println("execution time: " + exetime);
	}
}
