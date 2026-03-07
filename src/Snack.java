import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Snack {
    public int score=0;
    public int cnt=0;
    public static LinkedList<Point> arrayList;
    public static int direction= 3;
    public Snack(){
         arrayList=new LinkedList<>();
        arrayList.add(new Point(255,150));
        arrayList.add(new Point(240,150));
        arrayList.add(new Point(225,150));
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
            windows.setSuccessornot();
        }
        Point pointt=arrayList.getFirst();
        for(int i=1;i<arrayList.size();i++){
            if(pointt.x==arrayList.get(i).getX()&&pointt.y==arrayList.get(i).getY()){
                windows.setSuccessornot();
            }
        }
        if(arrayList.getFirst().x<0||arrayList.getFirst().x>=435||arrayList.getFirst().y<0||arrayList.getFirst().y>=285){
            windows.setSuccessornot();
        }
        for(int i=0;i<food.getArrayList().size();i++){
            if(pointt.x==food.getArrayList().get(i).getX()&&pointt.y==food.getArrayList().get(i).getY()){
                arrayList.addFirst(food.getArrayList().get(i));
                food.getArrayList().remove(i);
                food.generateFood();
                score=score+10;
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

