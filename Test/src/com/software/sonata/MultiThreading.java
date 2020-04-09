package com.software.sonata;

class Share {
	int i;

	 //void SharedMethod()  // (Inconsistent Output)
	synchronized void SharedMethod()

	{
		System.out.println(" Thread:: "   +Thread.currentThread().getId());
		i = 10;
		System.out.println("Currently Running Thread:" +Thread.currentThread().getName()+ ":" +i);
		i = 20;
        System.out.println("Currently Running Thread:" +Thread.currentThread().getName()+  ":" +i);
		i = 30;
		System.out.println("Currently Running Thread:" +Thread.currentThread().getName()+ ":" +i);

	}
}

public class MultiThreading {
	public static void main(String[] args) {
		Share s1 = new Share();

		Thread t1 = new Thread() {
			@Override
			public void run()

			{
				System.out.println("Thread-0 Alive/Dead in Run Method  "  + " : " +this.isAlive());
				 System.out.println("Thread-0 Name "+  " : "  +this.getName());											
				s1.SharedMethod();
			}
		};
		System.out.println("Thread-0 Alive/Dead After Run Method " + " : "   +t1.isAlive());
		

		Thread t2 = new Thread() {
	
			
			@Override
			public void run()

			{
				System.out.println("Thread-1  Alive/Dead in run Method" + " : " +this.isAlive());
				System.out.println("Thread -1 Name" +  "  : " +this.getName());
				s1.SharedMethod();
			}
		};
		System.out.println("Thread -1 Alive/Dead After Run Method"+  "  : " +t2.isAlive());

		t1.start();

		t2.start();
	}
}



