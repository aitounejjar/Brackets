import java.util.Scanner;

/**
 * Created by Mouhcine on 11/02/17.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println();

        Scanner sc = new Scanner(System.in);

        /*
        // use this for file input ...
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/main/java/input.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }*/


        int count = 0;
        while (sc.hasNextLine()) {
            Runnable runnable = new RunnableBracketMatcher(++count, sc.nextLine());
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}
