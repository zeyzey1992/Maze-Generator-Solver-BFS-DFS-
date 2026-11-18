
public class QueueArrayBased implements QueueInterface {

    private static final int INITIAL_CAPACITY = 50;
    private Object[] items;
    private int front;
    private int back;
    private int count;

    public QueueArrayBased() {
        items = new Object[INITIAL_CAPACITY];
        front = 0;
        back = items.length - 1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void enqueue(Object newItem) {
        if (isFull()) {
            resize(items.length * 2);
        }

        back = (back + 1) % items.length;
        items[back] = newItem;
        count++;
    }

    public Object dequeue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("QueueException on dequeue: Queue empty");
        }

        Object queueFront = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        count--;
        return queueFront;
    }

    public void dequeueAll() {
        items = new Object[INITIAL_CAPACITY];
        front = 0;
        back = items.length - 1;
        count = 0;
    }

    public Object peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Queue exception on peek: Queue empty");
        }
        return items[front];
    }

    private void resize(int newCapacity) {
        Object[] expanded = new Object[newCapacity];

        for (int i = 0; i < count; i++) {
            expanded[i] = items[(front + i) % items.length];
        }

        items = expanded;
        front = 0;
        back = count - 1;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("*******************");
        System.out.println("FRONT -> ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % items.length;
            System.out.print(items[index] + " -> ");
        }
        System.out.println("BACK");
        System.out.println("*******************");
    }
}
