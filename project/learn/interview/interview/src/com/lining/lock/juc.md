CountDownLatch

让一些线程阻塞 直到另一些线程 完成一系列操作后才被唤醒。

CountDownLatch 主要有两个方法，当一个或多个线程调用await方法时，调用线程会被堵塞。

其他线程调用countDown方法会将计数器 -1（调用此方法的线程不会被堵塞）。

当计数器的值变为零时，堵塞的线程会被唤醒，继续执行。

例子： 秦灭六国



CyclicBarrier

例子： 集七龙珠



Semaphore

例子： 车位

