import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Food {
    LinkedList<Point> arrayList;
    public Food(){
        arrayList=new LinkedList<>();
    }
    public void generateFood(){
        Random rm=new Random();
        int r1=rm.nextInt(450)/15*15;
        int r2=rm.nextInt(300)/15*15;
        arrayList.add(new Point(r1,r2));
    }
    public LinkedList<Point> getArrayList(){
        return arrayList;
    }
}
