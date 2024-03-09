import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoadBalancer {

  private Map<Integer, Integer> members = new HashMap<Integer, Integer>();

  LoadBalancer() {
    members.put(1, 0);
    members.put(2, 0);
    members.put(3, 0);
    members.put(4, 0);
    members.put(5, 0);
  }

  public void assignTask() {
    int minValue = Integer.MAX_VALUE;
    int minKey = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> m : members.entrySet()) {
      if (m.getValue() < minValue) {
        minValue = m.getValue();
        minKey = m.getKey();
      }
    }
    members.put(minKey, ++minValue);
  }

  public void completeTask(int key) {
    int num = members.get(key);
    if (num > 0) {
      members.put(key, --num);
    } else {
      System.out.println("No task assigned");
    }
  }

  public void display() {
    for (Map.Entry<Integer, Integer> m : members.entrySet()) {
      System.out.print(m.getKey() + " (" + m.getValue() + ") \t");
    }
    System.out.println("\n");
  }
}

class Main {

  public static void main(String[] args) {
    LoadBalancer lb = new LoadBalancer();
    Scanner sc = new Scanner(System.in);

    boolean toExit = false;

    while (!toExit) {
      lb.display();
      String cmd;
      System.out.print("Enter command ( 'A' to assign, 'C(1,2,3,4,5)' to complete, 'E' or 'e' to exit) : ");
      cmd = sc.next();

      switch (cmd) {
        case "A", "a":
          lb.assignTask();
          break;
        case "C1", "c1":
          lb.completeTask(1);
          break;
        case "C2", "c2":
          lb.completeTask(2);
          break;
        case "C3", "c3":
          lb.completeTask(3);
          break;
        case "C4", "c4":
          lb.completeTask(4);
          break;
        case "C5", "c5":
          lb.completeTask(5);
          break;
        case "E", "e":
          toExit = true;
          System.out.println("Exited...");
          break;
        default:
          System.out.println("Invalid value!!");
          break;
      }
    }
  }
}
