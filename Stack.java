public class Stack {
    private int[] arr;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;
    }

    // Method to push an element onto the stack
    public void push(int element) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push more elements.");
            return;
        }
        arr[++top] = element;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return a sentinel value indicating an empty stack
        }
        return arr[top--]; // Return the element at the current top index and then decrement top.
    }

    // Method to get the top element of the stack without removing it
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            return -1; // Return a sentinel value indicating an empty stack
        }
        return arr[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to get the size of the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();

    }

}
