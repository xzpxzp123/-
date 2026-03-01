import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Getfood {
    public static  void get(ArrayList<Point> arrayList){
        Random r1=new Random();
        int n1=r1.nextInt(450)/15*15;
        int n2=r1.nextInt(300)/15*15;
        arrayList.add(new Point(n1,n2));
    }
}
