import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.removeLast();
    }

    public void clear() {
        stack.clear();
    }
  
    public boolean isEmpty() {
        return stack.isEmpty();
    }
  
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements: " + stack);
        }
    }

    public static void main(String[] args) {
        // Create a stack of String
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.display();
        System.out.println("The pop element is: " + stringStack.pop());
        stringStack.display();
        stringStack.clear();
        stringStack.display();

        // Create a stack of Integer
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.display();
        System.out.println("The pop element is: " + integerStack.pop());
        integerStack.display();
        integerStack.clear();
        integerStack.display();
    }
}

