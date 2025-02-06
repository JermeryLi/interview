# interview

## java基础
* 为什么重写equals()就一定要重写hashCode()方法？
    
    如果只重写equals()方法，不重写hashCode()方法，就有可能导致a.equals(b)这个表达式成立，但是hashCode却不同。
    只重写了equals()方法的对象，在使用散列集合进行存储的时候，就会出现问题。
    因为散列集合是使用hashCode来计算key的存储位置。
    如果存储两个完全相同的对象，但是有不同的hashCode值，就会导致这两个对象存储在hash表的不同位置。
    当我们通过对象去获取数据的时候，就会出现一个悖论。两个完全相同的对象就会出现在hash表的不同位置，就会破坏约定俗成的规则，出现错误。
    
* Spring中有两个id相同的bean会报错吗？