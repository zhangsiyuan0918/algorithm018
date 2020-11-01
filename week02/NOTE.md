学习笔记
HashMap
数据结构：数组+链表
1.整体是一个数组
2.数组的每一个位置是一个链表
3.链表内的Value---->存储的Object

工作原理：
默认容量大小：16，加载因子0.75，阈值 = 初始容量 * 加载因子 = 12；
以put方法为例：

第一步：通过 HashMap 自己提供的hash 算法算出当前 key 的hash 值
第二步：通过计算出的hash 值去调用 indexFor 方法计算当前对象应该存储在数组的几号位置
第三步：判断size 是否已经达到了当前阈值，如果没有，继续；如果已经达到阈值，则先进性数组扩容，将数组长度扩容为原来的2倍。
注意：size 是当前容器中已有 Entry 的数量，不是数组长度。
第四步：将当前对应的 hash，key，value封装成一个 Entry，去数组中查找当前位置有没有元素，如果没有，放在这个位置上；如果此位置上已经存在链表，那么遍历链表，如果链表上某个节点的 key 与当前key 进行 equals 比较后结果为 true，则把原来节点上的value 返回，将当前新的 value替换掉原来的value，如果遍历完链表，没有找到key 与当前 key equals为 true的，就把刚才封装的新的 Entry中next 指向当前链表的始节点，也就是说当前节点现在在链表的第一个位置，简单来说即，先来的往后退。
扩容机制：
HashMap 使用 “懒扩容” ，只会在 PUT 的时候才进行判断，然后进行扩容。
	1. 将数组长度扩容为原来的2 倍
	2. 将原来数组中的元素进行重新放到新数组中
需要注意的是，每次扩容之后，都要重新计算原来的 Entry 在新数组中的位置，为什么数组扩容了，Entry 在数组中的位置发生变化了呢？所以我们会想到计算位置的 indexFor 方法，为什么呢，我摘出了该方法的源码如下：

1. static int indexFor(int h, int length) { // h 为key 的 hash值；length 是数组长度
 return h & (length-1);  
}
3、HashMap和HashTable 的异同
	1. 二者的存储结构和解决冲突的方法都是相同的。
	2. HashTable在不指定容量的情况下的默认容量为11，而HashMap为16，Hashtable不要求底层数组的容量一定要为2的整数次幂，而HashMap则要求一定为2的整数次幂。
	3. HashTable 中 key和 value都不允许为 null，而HashMap中key和value都允许为 null（key只能有一个为null，而value则可以有多个为 null）。但是如果在 Hashtable中有类似 put( null, null)的操作，编译同样可以通过，因为 key和 value都是Object类型，但运行时会抛出 NullPointerException异常。
	4. Hashtable扩容时，将容量变为原来的2倍+1，而HashMap扩容时，将容量变为原来的2倍。
	5. Hashtable计算hash值，直接用key的hashCode()，而HashMap重新计算了key的hash值，Hashtable在计算hash值对应的位置索引时，用 %运算，而 HashMap在求位置索引时，则用 &运算。
4、如何优化 HashMap？
初始化 HashMap 的时候，我们可以自定义数组容量及加载因子的大小。所以，优化 HashMap 从这两个属性入手，但是，如果你不能准确的判别你的业务所需的大小，请使用默认值，否则，一旦手动配置的不合适，效果将适得其反。
threshold = (int)( capacity * loadFactor );
阈值 = 容量 X 负载因子；
初始容量默认为16,负载因子(loadFactor)默认是0.75; map扩容后，要重新计算阈值；当元素个数 大于新的阈值时，map再自动扩容；以默认值为例，阈值=16*0.75=12，当元素个数大于12时就要扩容；那剩下的4个数组位置还没有放置对象就要扩容，造成空间浪费，所以要进行时间和空间的折中考虑；
loadFactor过大时，map内的数组使用率高了，内部极有可能形成Entry链，影响查找速度；
loadFactor过小时，map内的数组使用率较低，不过内部不会生成Entry链，或者生成的Entry链很短，由此提高了查找速度，不过会占用更多的内存；所以可以根据实际硬件环境和程序的运行状态来调节loadFactor；

