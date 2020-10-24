// 641 设计循环双端队列
// design-circular-deque

//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 60 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {
    //设计head和tail指针变量
    //head == tail 表示队列为空
    //tail + 1 == head ----> (tail + 1) % n == head 表示队列已满
    private int capacity;
    private int[] arr;
    private int front;
    private int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    //构造函数,双端队列的大小为k。
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        //头部指向第一个存放元素的位置
        //插入时，先减在赋值
        //删除时，索引+1
        front = 0;
        //尾部指向下一个插入元素的位置
        //插入时，先赋值，再加
        //删除时，索引-1
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    //将一个元素添加到双端队列头部。 如果操作成功返回 true。
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    //将一个元素添加到双端队列尾部。如果操作成功返回 true。
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    //deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        //front被设计在数组的开头，所以是+1
        front = (front + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    //deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    //getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        //当rear为0时，防止数组越界
        return arr[(rear - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    //检查双端队列是否为空。
    public boolean isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular deque is full or not. */
    //检查双端队列是否满了。
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

