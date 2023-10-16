import java.util.Random;

// 简单窗体类: 具体构件类
public class Main {
    public static void main(String[] args) {
        Mainframe mainframe=new Mainframe();
        mainframe.on();
    }
}
class Mainframe{
    private Memory memory;
    private CPU cpu;
    private HardDisk hardDisk;
    private OS os;
    public Mainframe(){
        memory=new Memory();
        cpu=new CPU();
        hardDisk =new HardDisk();
        os=new OS();
    }
    public void on(){
        try {
            memory.check();
            cpu.run();
            hardDisk.read();
            os.load();
        }
        catch (Exception e){
            System.out.println("启动失败");
        }
    }
}
class Memory{
    public void check(){
        Random random = new Random();
        if(random.nextDouble()<0.8)
            System.out.println("Memory启动成功");
        else{
            System.out.println("Memory启动失败");
            throw new ArithmeticException("");
        }

    }
}
class CPU{
    public void run(){
        Random random = new Random();
        if(random.nextDouble()<0.8)
            System.out.println("CPU启动成功");
        else{
            System.out.println("CPU启动失败");
            throw new ArithmeticException("");
        }
    }
}
class HardDisk{
    public void read(){
        Random random = new Random();
        if(random.nextDouble()<0.8)
            System.out.println("HardDisk启动成功");
        else{
            System.out.println("HardDisk启动失败");
            throw new ArithmeticException("");
        }
    }

}
class OS{
    public void load(){
        Random random = new Random();
        if(random.nextDouble()<0.8)
            System.out.println("OS启动成功");
        else{
            System.out.println("OS启动失败");
            throw new ArithmeticException("");
        }
    }
}