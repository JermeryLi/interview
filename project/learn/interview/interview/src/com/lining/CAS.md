CAS是什么？
比较并交换
compare and swap
AtomicInteger atomicInteger = new AtomicInteger(5);
atomicInteger.compareAndSet(5, 2019);      
atomicInteger.compareAndSet(5, 2019);

底层原理
unsafe   自旋锁

Unsafe
 它是CAS的核心类。由于Java方法无法直接访问底层系统，需要通过本地native方法来访问。Unsafe相当于一个后门，
基于该类可以直接操作特定内存的数据。
	unsafe类存在于sun.misc包中，其内部方法操作可以像C的指针一样直接操作内存。因为Java中CAS操作执行
	以来Unsafe类的方法。
	unsafe JVM实现汇编指令。这完全以来硬件的功能，不会被打断。
	是一种系统原语。执行必须是连续的。
	
CAS的缺点
	do whlie
	如果比较失败 会重新进入循环。 长时间不成功的话，会为CPU带来很大的开销。
	
CAS的ABA问题
