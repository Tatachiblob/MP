import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        final String FORMAT = "%8s %6s Money%,5d";
        String s = String.format(FORMAT, "YUTA", "Hero", "32000");
        System.out.println(s);
    }
}
