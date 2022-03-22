package DateStruckStudy;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {

    private Object[] arr;//存放数据的物理结构

    private int StackLength = 4;//默认长度

    private int size;//记录栈中元素个数

    private int index = -1; //指针





    /**
     * 判断栈是否为空
     * @return
     */
    public boolean Empty(){
        if(index==-1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 取出栈顶元素并返回
     * @return
     */
    public T pop(){
        //如果无元素，抛出异常
        if(this.index==-1){
            throw new EmptyStackException();

        }
        this.size--;


        return (T)this.arr[index--];
    }


    /**
     * 添加元素
     * @param item
     * @return
     */
    public T push(T item){
        this.capacity();
        this.arr[++index] = item;
        this.size++;

        return item;
    }

    /**
     * 初始化及扩容
     */
    private void capacity(){
        if(this.arr == null)
        {
            this.arr = new Object[this.StackLength];
        }
        //扩容
        if(this.size-(this.StackLength-1)>=0){
            this.StackLength = this.StackLength+(this.StackLength>>1);
            this.arr = Arrays.copyOf(this.arr,this.StackLength);

        }

    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.push("e");
        myStack.push("f");
        System.out.println(myStack.size);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }
}
