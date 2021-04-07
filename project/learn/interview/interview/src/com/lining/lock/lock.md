公平锁和非公平锁、 可重入锁（递归锁）、自旋锁、独占锁（写锁）和共享锁（读锁）、互斥锁

```java
ReentrantLock lock = new ReentrantLock();
```

空参构造为非公平锁。  可选参数true false。 当参数是true时，创建公平锁。

```java
public ReentrantLock(boolean fair) {
    sync = fair ? new FairSync() : new NonfairSync();
}
```

公平锁： 多线程按照申请的顺序来获取锁，类似排队打饭，先来后到。

非公平锁：多线程按照获取所得顺序不是按照申请锁的顺序。有可能后申请锁的线程优先获得锁。

​	所以在高平发的情况下，有可能造成优先级反转或饥饿的现象。

​	非公平锁，上来就直接尝试占有锁，如果尝试失败，就再采用类似公平锁的那种方式。

​	吞吐量较大。 synchronized是非公平锁。



可重入锁(又名递归锁)

同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码。在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。 线程可以进入任何一个它已经拥有锁所同步的代码块。

ReentrantLock、synchronized是可重入锁。 可重入锁的最大作用是避免死锁。





自旋锁

尝试获取锁的线程不会立即堵塞，而是采用循环的方式去尝试获取锁。这样的好处是减少线程上下文切换的消耗。缺点是循环会消耗CPU。

列子： getAndAddInt();

手写自旋锁。





独占锁

​	改锁一次只能被一个线程所持有。 ReentrantLock、 synchronized

​	ReetrantReadWriteLock

共享锁

读写锁 读写分离

​	写操作： 原子+独占  整个过程必须是一个完整的统一体，中间不许被分割，被打断。





Lock 和synchronized 区别

1、synchronized  是关键字  属于JVM层面。

​	monitorenter 底层是通过monitor对象来实现的。wait/notify等方法也依赖monitor对象。只有在同步块或方法才能调用wait、notify等方法。

​	monitorenter   1正常退出 monitorexit 2 异常退出 monitorexit  保证可以退出

Lock api层面

2、使用

​	synchronized 不需要用户手动释放锁 当代码块或方法执行完成后系统会自动释放对锁的占用

​	lock 需要手动释放锁，否则会出现死锁现象。

​	lock 需要配合try final 使用

3、等待是否可以中断

​	synchronized 不可以 中断，除非正常运行完成或异常

​	lock 可以冲断。设置超时时间 interrupt()

4、加锁是否公平

​	lock  ReentrantLock 默认是非公平锁  也可以设置公平锁

​	synchronized 非公平锁

5、唤醒 绑定多个条件condition

​	synchronized 没有 

​	ReentrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒。而不是synchronized要么随机唤醒一个  要么全部唤醒。

例题：  A线程打印5次， B打印10次，C打印15次  循环10论