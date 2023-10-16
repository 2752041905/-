import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CollegeSearchGUI gui = new CollegeSearchGUI();
                gui.setVisible(true);
            }
        });
    }
}
class Factory {
    College getcollege(String college) {
        switch (college) {
            case "计算机与信息学院":
                return new cs();
            case "物理与电子信息学院":
                return new physics();
            case "数学与统计学院": {
                return new mathematics();
            }
            case "音乐学院": {
                return new music();
            }
            case "体育学院": {
                return new PE();
            }
            case "文学院": {
                return new Literature();
            }
            default:
                System.out.println("无结果");
        }
        return null;
    }
}
interface College {
    public String getDean();
    public String getBriefly();
    public String display();
}

class CollegeBase implements College {
    private String dean;
    private String briefly;

    public CollegeBase(String dean, String briefly) {
        this.dean = dean;
        this.briefly = briefly;
    }

    @Override
    public String getDean() {
        return dean;
    }

    @Override
    public String getBriefly() {
        return briefly;
    }

    @Override
    public String display() {
        return dean + '\n' + briefly;
    }
}

class cs extends CollegeBase{
    public cs(){
        super("罗永龙","计算机与信息学院是学校主动适应国家发展大局和战略调整，" +
                "积极融入地方经济社会转型和创新发展，实现创新型IT人才培养的跨越式发展，由计算机类专业组建成立的新学院。" +
                "学校依托数学专业早在上世纪50年代开始了计算机学科的研究。" +
                "1987年学校开始招收计算机专业专科生；1988年，学校在数学教育专业招收主修计算机方向的本科生；1992年，" +
                "学校成立计算机科学教育系，经教育部批准正式招收计算机科学教育专业本科生，是省内较早开展计算机本科人才培养的单位。" +
                "1999年4月，计算机科学教育系与数学系、计算中心合并成立数学计算机科学学院。" +
                "2005年5月原芜湖师范专科学校数学系和计算机教学部整体并入安徽师范大学数学计算机科学学院。" +
                "2018年1月，学校决定成立计算机与信息学院。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class physics extends CollegeBase{
    public physics(){
        super("郑贤锋","安徽师范大学物理与电子信息学院前身是1929年创建于安庆市省立安徽大学理学院物理系，" +
                "是国内较早建立的大学物理系之一。1949年12月成建制迁至芜湖，2000年4月成立物理与电子信息学院，" +
                "2005年6月，芜湖师范专科学校物理系并入物理与电子信息学院。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class mathematics extends CollegeBase{
    public mathematics(){
        super("任永","学院源于省立安徽大学数学系，创建于1929年9月；1992年，创办计算机系；" +
                "1999年4月，数学系、计算机系、计算中心合并组建数学计算机科学学院；" +
                "2005年5月，原芜湖师范专科学校数学系和计算机教学部整体并入；2018年1月，更名为数学与统计学院。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class music extends CollegeBase{
    public music(){
        super("汪海元","安徽师范大学音乐学院始建于1943年，历经安徽师范学院艺术科、皖北师范文艺干校、" +
                "安徽艺术学院、合肥师范学院艺术系、安徽师范大学艺术系、音乐系等历史沿革，2001年12月经批准正式成立音乐学院。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class PE extends CollegeBase{
    public PE(){
        super("金涛","安徽师范大学体育学院，始建于1957年，前身为安徽师范学院体育科，1960年并入安徽体育学院，" +
                "1961年开始招收体育教育专业本科生，1962年迁回皖南大学成立体育系，1993年在安徽师范大学体育系基础上成立体育学院。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class Literature extends CollegeBase{
    public Literature(){
        super("项念东","安徽师范大学文学院前身是1928年建立的省立安徽大学中国文学系，是安徽省高校" +
                "办学历史最悠久的中文院系，刘文典、郁达夫、陈望道、苏雪林、" +
                "周予同、方光焘、潘重规、宛敏灏、张涤华、祖保泉等一批著名学者曾在中文系工作，秉承“文以载道、" +
                "学以化人”的院训，形成优良的学术传统。");
    }
    @Override
    public String display(){
        return super.getDean()+'\n'+super.getBriefly();
    }
}
class CollegeSearchGUI extends JFrame{
    JLabel jLabel;
    JTextField jTextField;
    JButton jButton;
    JTextArea jTextArea;
    public CollegeSearchGUI(){
        init();
    }
    void init(){
        setTitle("学院搜索");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Set the size of the window
        setLocationRelativeTo(null); // Center the window
        setLayout(new FlowLayout()); // Use FlowLayout for simplicity

        // Create and configure components
        jLabel = new JLabel("学院搜索");
        jTextField = new JTextField(20); // 20 columns for input
        jButton = new JButton("确认");
        jTextArea = new JTextArea(10, 40); // 10 rows and 30 columns for text area
        jTextArea.setEditable(false); // Make text area read-only
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        // Add components to the JFrame
        add(jLabel);
        add(jTextField);
        add(jButton);
        add(jTextArea);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event here
                String searchQuery = jTextField.getText();
                Factory factory = new Factory();
                College clg=factory.getcollege(searchQuery);
                // You can perform a search and update the JTextArea with the results here
                if (clg!=null){
                    jTextArea.setText("搜索结果:\n" + clg.display());
                }
                else{
                    jTextArea.setText("无结果");
                }
            }
        });
    }
}
