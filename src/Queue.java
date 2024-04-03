public class Queue<T> implements QueueInterface<T> {
    private Node<T> head, tail;
    private int count;
    private final int sizeLimit; //Not sure this is  ||  hold on to this.

    private class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }


    @Override
    public void enqueue(Object element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        Node<T> newNode = (Node<T>) new Node<>(element); //Might have to cast
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }

        T element = head.element;
        head = head.next;

        count--;

        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    @Override
    public T peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return head.element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0; //Changed from false
    }

    @Override
    public boolean isFull() {
        return count == sizeLimit;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.element.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
