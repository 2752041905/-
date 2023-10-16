
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String args[]){
        JFrame frame = new JFrame("安徽师范大学学院简介查询");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // 创建学院选择下拉框
        JComboBox<String> collegeComboBox = new JComboBox<>(new String[]{"计算机与信息学院", "文学院", "物理与电子信息学院", "化学与材料科学学院", "历史学院", "生命科学学院"});
        frame.add(collegeComboBox);

        // 创建文本框用于显示学院简介
        JTextArea introductionTextArea = new JTextArea(15, 30);
        introductionTextArea.setLineWrap(true);
        introductionTextArea.setWrapStyleWord(true);
        introductionTextArea.setEditable(false);
        frame.add(introductionTextArea);

        // 创建查询按钮
        JButton queryButton = new JButton("查询");
        frame.add(queryButton);

        // 查询按钮点击事件
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCollege = (String) collegeComboBox.getSelectedItem();
                CollegeFactory factory = null;

                // 根据选择的学院，使用对应的工厂创建学院对象
                switch (selectedCollege) {
                    case "计算机与信息学院":
                        factory = new ComputerScienceFactory();
                        break;
                    case "文学院":
                        factory = new LiteratureFactory();
                        break;
                    case "物理与电子信息学院":
                        factory = new PhysicsFactory();
                        break;
                    case "化学与材料科学学院":
                        factory = new ChemistryFactory();
                        break;
                    case "历史学院":
                        factory = new HistoryFactory();
                        break;
                    case "生命科学学院":
                        factory = new LifeScienceFactory();
                        break;
                }

                if (factory != null) {
                    College college = factory.createCollege();
                    introductionTextArea.setText(college.getIntroduction());
                } else {
                    introductionTextArea.setText("暂无该学院信息");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

}

// 学院接口
interface College {
    String getIntroduction();
}

// 具体学院类
class ComputerScience implements College {
    @Override
    public String getIntroduction() {
        return "计算机与信息学院的简介：计算机与信息学院是学校主动适应国家发展大局和战略调整，积极融入地方经济社会转型和创新发展，实现创新型IT人才培养的跨越式发展，由计算机类专业组建成立的新学院。学院现有生物信息学二级学科博士点，设有计算机科学与技术一级学科硕士点以及计算机系统结构、计算机软件与理论、计算机应用技术等3个二级学科硕士点，拥有计算机科学与技术（国家级一流本科专业建设点）、软件工程、物联网工程、网络空间安全、人工智能、数据科学与大数据技术等6个本科专业。";
    }
}

class Literature implements College {
    @Override
    public String getIntroduction() {
        return "文学院的简介：文学院现设有汉语言文学、汉语言、秘书学、对外汉语等4个本科专业；文学研究所、语言研究所、古籍整理研究所、美育与审美文化研究所等4个研究所。具有中国语言文学博士后科研流动站，中国古代文学博士学位授予权,中国语言文学硕士学位授予权一级学科；设有中国古代文学、汉语言文字学、文艺学、中国现当代文学、美学、中国古典文献学、语言学及应用语言学、比较文学与世界文学、语文学科教学论以及艺术学等10个硕士学位授权点和语文学科教育、汉语国际教育两个专业学位点； 1个国家级特色专业建设点(汉语言文学专业)，1个国家级教学团队（中国古代文学），2门国家级精品课程（文学理论、大学语文），1个首批省级教改示范专业 (汉语言文学专业)，1个安徽省A类重点学科（中国语言文学），3个安徽省B类重点学科(中国古代文学、汉语言文字学、中国现当代文学)，5个校级重点学科(中国古代文学、中国现当代文学、文艺学、汉语言文字学、美学)，5门省级精品课程(文学理论、中国古代文学、中国现代文学史、古代汉语、秘书学概论)，1个省级重点课程(现代汉语)，1个省级刊物(《学语文》)。";
    }
}

class Physics implements College {
    @Override
    public String getIntroduction() {
        return "物理与电子信息学院的简介：安徽师范大学物理与电子信息学院前身是1929年创建于安庆市省立安徽大学理学院物理系，是国内较早建立的大学物理系之一。1949年12月成建制迁至芜湖，2000年4月成立物理与电子信息学院，2005年6月，芜湖师范专科学校物理系并入物理与电子信息学院。\n" +
                "\n" +
                "在90多年的办学过程中，张文渊、金肖宗、夏敬农、雷瀚、吴锐、陆同兴等一批从国外归来的著名学者曾在这里任教和从事科学研究，形成了严谨治学的优良学风和深厚的学术底蕴。学院始终秉承“理实交融，德才兼备”的院训，坚持“质量立院、科研强院、人才兴院、民主治院”的办院方针，把高质量的人才培养作为学院的根本任务。办学至今，学院先后为国家政治、经济、教育、科技、文化等领域输送了大批优秀人才，有1人入选中国科学院院士，10人获国家杰出青年科学基金资助；有百余名毕业生已成为基础教育界业务骨干、示范高中校长或教育行政部门主要管理者，以及众多成功企业界人士。";
    }
}

class Chemistry implements College {
    @Override
    public String getIntroduction() {
        return "化学与材料科学学院的简介：化学与材料科学学院缘起1929年创立的省立安徽大学理学院化学系，至今已有90余年的办学历史。学院成立后，办学规模、办学层次、办学水平都得到快速提升，学院办学实力进入了一个全新的发展阶段。学院现已经形成了博士—硕士—学士教育等不同层次，全日制高等教育、成人高等教育、留学生教育等不同类型的完整人才培养体系，已发展成为一个师范与非师范、理学与工学并举的学院。现有全日制本科生1900人，研究生、留学生、博士后工作人员560人。\n" +
                "\n" +
                "学院现设有化学（师范）、化学（拔尖人才班）、应用化学、材料化学（2023年招生为新能源材料与器件专业）、化学工程与工艺5个本科专业。拥有国家级一流专业、国家一流课程、国家级实验教学示范中心、国家级教学团队等10个国家级本科教育教学平台以及多个省级教育教学平台。化学专业于2019年通过教育部师范类专业二级认证。";
    }
}

class History implements College {
    @Override
    public String getIntroduction() {
        return "历史学院的简介：安徽师范大学历史学院源于1928年创办的省立安徽大学，历经文史、史地、历史等系科的发展，至今已有90余年办学历史，是安徽省高校办学历史最悠久的系科之一，也是安徽省最早拥有硕士（1982年）、博士（2003年）学位授予权和博士后科研流动站（2007年）的历史学科。著名学者吕思勉、周予同、陈守实、李则纲、束世澂、汪诒荪、唐德刚、光仁洪、陈正飞、胡澱咸、万绳楠、张海鹏、苏诚鉴、陈怀荃、汪宏玉、王廷元、叶孟明等先后在此弘文励教，形成优良的办学传统。";
    }
}

class LifeScience implements College {
    @Override
    public String getIntroduction() {
        return "生命科学学院的简介：安徽师范大学生命科学学院的前身生物系创建于1930年，1952年建立生物系，1959年与原合肥师范学院生物系合并成立新的生物系，2000年4月组建为生命科学学院,2005年芜湖师范专科学校化生系并入学院，2020年学校将原环境科学与工程学院食品质量与安全、食品科学与工程等专业调整至生命科学学院。建院（系）90年以来，曾经有王志稼、钱啸虎、刘承德、陈壁辉等多位在全国享有盛名的教授在此执教。";
    }
}

// 学院工厂接口
interface CollegeFactory {
    College createCollege();
}

// 具体学院工厂类
class ComputerScienceFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new ComputerScience();
    }
}

class LiteratureFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new Literature();
    }
}

class PhysicsFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new Physics();
    }
}

class ChemistryFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new Chemistry();
    }
}

class HistoryFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new History();
    }
}

class LifeScienceFactory implements CollegeFactory {
    @Override
    public College createCollege() {
        return new LifeScience();
    }
}

