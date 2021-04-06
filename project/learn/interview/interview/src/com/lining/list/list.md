ArrayList
	非线程安全
	1、现象 
		多线程增加元素会有这个异常： ConcurrentModificationException
	2、原因
		add 方法没有加锁 synchronized
	3、解决方法
		1、new Vector()
			用Vector可以解决 其add方法加了锁
			ArrayList since1.2
			Vector since1.1 可以说Vector被淘汰了 性能比较差
		2、可以去Collects 工具类中寻找对应的线程安全方法。
			List<String> list2 = Collections.synchronizedList(new ArrayList<>());
			可以从提示的方法看到 map 和 set也是非线程安全的。
			Collections.synchronizedMap()、synchronizedSe
		3、CopyOnWriteArrayList
			transient: 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化。

```
public boolean add(E e) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        Object[] elements = getArray();
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        newElements[len] = e;
        setArray(newElements);
        return true;
    } finally {
        lock.unlock();
    }
}
```



​	

HashSet

​	HashSet的底层是HashMap。

​	源码 map = new HashMap<>{};

​	添加的元素就是map对应的key, value是一个Object静态常量。



HashMap 

ConcurrentHashMap<>{};