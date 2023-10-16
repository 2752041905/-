import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Folder obj1,obj2,obj4;
        File obj3;
        obj1=new Folder("北京总部");
        obj2=new Folder("湖南分校");
        obj3=new ImageFile("教务办公室");
        obj4=new Folder("长沙教学点");
        obj1.add1(obj3);
        obj1.add1(obj2);
        obj2.add1(obj3);
        obj2.add1(obj4);
        obj4.add1(obj3);
        obj1.display();
    }
}
abstract class File{
    public abstract void display();
}
class Folder extends File{
    private ArrayList list=new ArrayList();
    private String filename;

    public Folder(String filename) {
        this.filename = filename;
    }
    public void add1(File e){
        list.add(e);
    }
    public void delete(File e){
        list.remove(e);
    }
    public static int cnt=1;
    @Override
    public void display() {
        System.out.println(filename);
        for(Object obj:list){
            System.out.print(cnt);
            cnt++;
            ((File)obj).display();
        }
    }
}
class ImageFile extends File{
    private String name;
    public ImageFile(String name) {
        this.name = name;
    }
    @Override
    public void display() {
     System.out.println("-"+name);
    }
}

