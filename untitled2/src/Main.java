import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cat car =new Adapter();
        Dog dog =new Adapter();
        car.cry();
        car.cathMouse();
        dog.wang();
        dog.action();
    }
}
interface Cat{
    public void cry();
    public void cathMouse();
}
class ConcreteCat implements Cat{

    @Override
    public void cry() {
        System.out.println("喵喵");
    }

    @Override
    public void cathMouse() {
        System.out.println("抓老鼠");
    }
}
interface Dog{
    public void wang();
    public void action();
}
class ConcreteDog implements Dog{

    @Override
    public void wang() {
        System.out.println("汪汪");
    }

    @Override
    public void action() {
        System.out.println("跳跳");
    }
}
class Adapter implements Cat,Dog{
    private Cat cat;
    private Dog dog;
    public Adapter(){
        cat=new ConcreteCat();
        dog=new ConcreteDog();
    }

    @Override
    public void cry() {
        System.out.println("猫模仿狗：");
        dog.wang();
    }

    @Override
    public void cathMouse() {
        System.out.println("猫模仿狗：");
        dog.action();
    }

    @Override
    public void wang() {
        System.out.println("狗模仿猫：");
        cat.cry();
    }

    @Override
    public void action() {
        System.out.println("狗模仿猫：");
        cat.cathMouse();
    }
}

