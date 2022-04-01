public class Queue_Str {
    int size_of_queue = 5; // the of the array
    int front, rear;
    String items_of_names[][] = new String[size_of_queue][3];//for insert string details

    Queue_Str() {
        front = -1;
        rear = -1;
    }

    // check the queue is full and pass true
    boolean isFull() {
        if (front == 0 && rear == size_of_queue - 1) {
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
        }else{
            return false;
        }
    }

    // Adding an element
    void empty_queue(String name,String f_name,String s_name) {
        if (isFull()) {
            System.out.println("--Queue is full--");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size_of_queue;
            items_of_names[rear][0] = name;//get the name and insert it to array index 0
            items_of_names[rear][1]=f_name;//get the f_name and insert it to array index 1
            items_of_names[rear][2]=s_name;//get the s_name and insert it to array index 2
            System.out.println("Inserted " + name +" to the queue.");
        }
    }

    // remove an element
    String[] del_queue() {
        String [] names_of_customer=new String[3];// to store and return a array content all thing about names
        String empty[]={"e","e","e"};//if the queue is empty the method return array contain three "empty"
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return empty;
        } else {
            names_of_customer[0] =items_of_names[front][0];//0 index for name
            names_of_customer[1] =items_of_names[front][1];//1 for f_name
            names_of_customer[2] =items_of_names[front][2];//2 for s_name
            if (front == rear) {
                front = -1;
                rear = -1;
            }else {// check the queue has only one element , and after that reset the queue
                front = (front + 1) % size_of_queue;
            }
            return (names_of_customer);
        }
    }

}

