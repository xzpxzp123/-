import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Snack {
    public static LinkedList<Point> arrayList;
    public static int direction= 0;
    public Snack(){
        arrayList=new LinkedList<>();
        arrayList.add(new Point(150,150));
        arrayList.add(new Point(150,165));
        arrayList.add(new Point(150,180));
    }
    public  void move(Food food){
      arrayList.removeLast();
       if(direction==0){
          arrayList.addFirst(new Point(arrayList.getFirst().x,arrayList.getFirst().y-15));
       }
       if(direction==1){
           arrayList.addFirst(new Point(arrayList.getFirst().x,arrayList.getFirst().y+15));
       }
        if(direction==2){
            arrayList.addFirst(new Point(arrayList.getFirst().x-15,arrayList.getFirst().y));
        }
        if(direction==3){
            arrayList.addFirst(new Point(arrayList.getFirst().x+15,arrayList.getFirst().y));
        }
        if(arrayList.getFirst().x<0||arrayList.getFirst().x>=450||arrayList.getFirst().y<0||arrayList.getFirst().y>=300){
            System.exit(0);
        }
        Point pointt=arrayList.getFirst();
        for(int i=1;i<arrayList.size();i++){
            if(pointt.x==arrayList.get(i).getX()&&pointt.y==arrayList.get(i).getY()){
                System.exit(0);
            }
        }
        if(pointt.getX()<0||pointt.getY()<0&&pointt.getX()>=450&&pointt.getY()>=300){
            System.exit(0);
        }
        for(int i=0;i<food.getArrayList().size();i++){
            if(pointt.x==food.getArrayList().get(i).getX()&&pointt.y==food.getArrayList().get(i).getY()){
                arrayList.addFirst(food.getArrayList().get(i));
                food.getArrayList().remove(i);
            }
        }
    }
    public LinkedList<Point> getLinkedList(){
        return arrayList;
    }
    public void setDirection(int direction){
        this.direction=direction;
    }
    public int getDirection(){
        return direction;
    }
    }

