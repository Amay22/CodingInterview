package Stacks;


public class PriorityMaxStack {
    int stack[];
    int maxStack[];
    int index;
    
    public PriorityMaxStack(){
        index = -1;
        stack = new int[100];
        maxStack = new int[100];    
    }
    public void push(int num){
        if(index >= 99){
            System.out.println("Stack Overflow. Cannot Push anymore");
            return;
        }
        index++;
        stack[index] = num;
        if(index != 0){
            maxStack[index] = maxStack[index-1] >= num ? maxStack[index-1] : num;                
        }else{            
            maxStack[0] = num;
        }                
    }
    public int pop(){
        if(index < 0){            
            System.out.println("Stack Underflow. Cannot Pop anymore");
            return -1;
        }              
        return stack[index--];
    }
    
    public int getMax(){    
        if(index < 0){            
            System.out.println("Stack Don't exist So, No Max");
            return Integer.MIN_VALUE;
        }
        System.out.println(maxStack[index]);
        return maxStack[index];
    }
    public void print(){  
        System.out.println("STACK");
        for (int i = 0; i <= index; i++) {
            System.out.print(stack[i]+" ,");
        }
        System.out.println("\nMAX");
        for (int i = 0; i <= index; i++) {
            System.out.print(maxStack[i]+" ,");
        }
    }
    public static void main(String[] args) {
        PriorityMaxStack ps = new PriorityMaxStack();
        ps.push(1);
        ps.push(11);
        ps.push(-131);
        ps.push(10);
        ps.push(100);        
        ps.pop();
        ps.pop();
        ps.getMax();
        ps.pop();
        ps.pop();
        ps.push(12);
        ps.pop();
        ps.getMax();
        ps.push(12);
        ps.pop();     
        ps.push(2);
        ps.getMax();
    }
}
