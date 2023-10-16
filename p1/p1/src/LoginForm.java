import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
public class LoginForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao =new UserDao();
        System.out.println("1添加用户 2修改密码 3删除用户");
        System.out.println("请输入一个整数");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login(userDao);
            }
        });
        int num = scanner.nextInt();
        while (num != 0){
            switch (num) {
                case 1:
                    System.out.println("请输入用户名");
                    String name = scanner.next();
                    System.out.println("请输入密码");
                    String password = scanner.next();
                    userDao.addUser(name,password);
                    System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("请输入用户名");
                    name = scanner.next();
                    System.out.println("请输入修改后的密码");
                    password = scanner.next();
                    userDao.updateUser(name,password);
                    System.out.println("修改成功");
                    break;
                case 3:
                    System.out.println("请输入要删除的用户名");
                    name= scanner.next();
                    userDao.deleteUser(name);
                    System.out.println("删除成功");
                    break;
                default:
                    System.out.println("输入错误");
            }
            num = scanner.nextInt();
        }

    }
}
class Login extends JFrame{
    JLabel jl1,jl2,jl3;
    JTextField name;
    JPasswordField password;
    JButton login,exit;
    Font f;
    private UserDao userDao;
    public Login(UserDao userDao){
        this.userDao=userDao;
        init();
    }
    void init(){
        setTitle("登录页面");
        setBounds(200,200,400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        f = new Font("仿宋",Font.BOLD+ Font.ITALIC,30);
        jl1 = new JLabel("欢迎登录");
        jl1.setFont(f);
        jl2 = new JLabel("账号");
        jl3 = new JLabel("密码");
        name = new JTextField(10);
        password = new JPasswordField(10);
        login = new JButton("登录");
        exit = new JButton("退出");
        jl1.setBounds(150,10,150,80);
        jl2.setBounds(80,80,120,30);
        jl3.setBounds(80,130,120,30);
        name.setBounds(120,80,200,30);
        password.setBounds(120,130,200,30);
        login.setBounds(130,180,80,30);
        exit.setBounds(230,180,80,30);
        add(jl1);
        add(jl2);
        add(jl3);
        add(name);
        add(password);
        add(login);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里执行退出操作
                System.exit(0); // 使用 System.exit(0) 来关闭应用程序
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Name = name.getText();
                String Password = new String(password.getPassword());
                if (userDao.validateUser(Name,Password)){
                    JOptionPane.showMessageDialog(null,"登录成功");
                }
                else{
                    JOptionPane.showMessageDialog(null,"登录失败");
                }
            }
        });
    }
}