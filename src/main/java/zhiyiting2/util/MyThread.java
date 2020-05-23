package zhiyiting2.util;

public class MyThread implements Runnable {
	public int n;
	public String[] str = {"123","456","789"};
	public MyThread(int n) {
		this.n=n;
	}
	public int getN() {
		return n;
	}



	public void setN(int n) {
		this.n = n;
	}



	public void run() {
		Thread.currentThread().setName(String.valueOf(n));
		for (int i = 0; i <= str.length; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + str[Integer.valueOf(Thread.currentThread().getName())]);
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			new Thread(new MyThread(i)).start();
		}
		
	}
	
	
	
	
}
