public class Queue_Num {
    int size_Of_queue = 5; // the of the array
    int front, rear;
    int items_of_numbers[][] = new int[size_Of_queue][2];//for insert number details

    Queue_Num() {
        front = -1;// set -1 to all
        rear = -1;
    }

    // check the queue is full and pass true
    boolean isFull() {
        if (front == 0 && rear == size_Of_queue - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check the queue is empty and pass true
    boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }

    // Adding an element
    void empty_queue(int number_of_guests,int credit_card_number) {
        if (isFull()) {
            System.out.println("Queue is full..");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size_Of_queue;
            items_of_numbers[rear][0] = number_of_guests;
            items_of_numbers[rear][1]=credit_card_number;
        }
    }

    // remove an element
    int[] del_queue() {
        int[] numbers=new int[2];
        int[]empty={0,0};//the array that sending when the queue is empty
        if (isEmpty()) {

            return empty;
        } else {
            numbers[0] = items_of_numbers[front][0];//number of guests
            numbers[1] = items_of_numbers[front][1];//credit card number
            if (front == rear) {
                front = -1;
                rear = -1;
            } // check the queue has only one element , and after that reset the queue
            else {
                front = (front + 1) % size_Of_queue;
            }
            return (numbers);
        }
    }
}

