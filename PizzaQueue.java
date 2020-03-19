import java.util.*;

public class PizzaQueue {
    private String[] date;
    private int size;

    public PizzaQueue() {
        this.date = new String[20];
        this.size = 0;
    }

    public boolean empty() {
        return this.size == 0;

//        if (size == 0) {
//            return true;
//        } else {
//            return false;
//        }

    }

    public String peek() {
        //Null pointer exception in this method

        return this.date[0];
        
        
//        if (date[0] == null) {
//            return null;
//        } else {
//            return date[0];
//        }


    }

    public void push(String dateOrdered) {

        if (size < 20) {
            date[size] = dateOrdered;
            size++;
         } else {
            System.out.println("Sorry we are at capacity try ordering again later");
         }

//        int i = 0;
//        boolean orderplaced = false;
//        if (size < maxCap) {
//            do {
//                if (date[i] == null) {
//                    date[i] = dateOrdered;
//                    size = size++;
//                    orderplaced = true;
//                }
//                i++;
//            } while (!orderplaced);
//        } else {
//            System.out.println("Sorry we are at capacity try ordering again later");
//        }


    }

    public String pop() {
        /*

         */

        String firstOrder;
        if (date[0] == null) {
            return null;
        } else {
            firstOrder = date[0];
            size--;
            for (int i = 1; i < date.length; i++) {
                date[i - 1] = date[i];
            }
        }
        return firstOrder;

    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return peek();

        // return super.toString();
    }
}