import java.util.ArrayList;
import java.util.ListIterator;

public class Queue<T> implements QueueInterface<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front, rear;
    private int sizeLimit;
    private int currentSize;

    public Queue(int sizeLimit) {
        this.sizeLimit = sizeLimit;
        this.front = this.rear = null;
        this.currentSize = 0;
    }

    public void enqueue(T element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        Node<T> newNode = new Node<>(element);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        currentSize++;
    }

    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T data = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        currentSize--;
        return data;
    }

    public T peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return this.front.data;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == sizeLimit;
    }

    public int size() {
        return this.currentSize;
    }

    public String toString() {
        ArrayList<T> tempStack = new ArrayList<>();
        Node<T> current = front;
        // Push all elements to a temporary stack to reverse their order
        while (current != null) {
            tempStack.add(current.data);
            current = current.next;
        }

        // Build the string from the temporary stack in reverse order
        StringBuilder sb = new StringBuilder("[");
        ListIterator<T> iter = tempStack.listIterator(tempStack.size());
        while (iter.hasPrevious()) {
            sb.append(iter.previous().toString());
            if (iter.hasPrevious()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
