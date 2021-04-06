队列

堵塞队列	

​	堵塞队列有没有好的一面

​	不得不堵塞，该如何管理



当堵塞队列是空时，从队列中获取元素的操作将会被堵塞。

当堵塞队列是满时， 往队列里添加元素的操作将会被堵塞。



BlockingQueue 核心方法

1、ArrayBlockingQueue  由数组结构组成的有界阻塞队列

2、LinkedBlockingQueue 由链表结构组成的有界（可以当作无界）阻塞队列  Integer.MAX_VALUE

3、PriorityBlockingQueue 支持优先级排序的无界阻塞队列

4、DelayQueue 使用优先级队列实现的延迟无界堵塞队列

5、Synchronous: 不存储元素的堵塞队列

6、LinkedTranseferQueue  由链表结构组成的无界堵塞队列

7、LinkedBlockingDeque  有链表结构组成的双向堵塞队列

idea 自带类图分析