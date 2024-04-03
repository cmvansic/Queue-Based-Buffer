public class Queue implements QueueInterface {

    @Override
    public void enqueue(Object element) throws QueueFullException {

    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        return null;
    }

    @Override
    public Object peek() throws QueueEmptyException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
