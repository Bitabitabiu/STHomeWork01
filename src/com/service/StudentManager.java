package com.service;

import com.pojo.Student;
import javafx.scene.input.DataFormat;

import java.awt.*;
import java.util.*;
import java.util.List;

public class StudentManager {
    Scanner in =new Scanner(System.in);
    public static int index=0;//数组下标
    public static int count=0;
    public static List<Student> stulist = new ArrayList<Student>();

    public void APP(){
        System.out.println();
        System.out.println("请输入你想执行的操作所对应的序号：");
        System.out.println("*********************************");
        System.out.println("**          1 插入             **");
        System.out.println("**          2 查找             **");
        System.out.println("**          3 删除             **");
        System.out.println("**          4 修改             **");
        System.out.println("**          5 输出             **");
        System.out.println("**          6 退出             **");
        System.out.println("*********************************");
        int number=in.nextInt();
        switch (number){
            case 1:
                addStu();
                APP();
                break;
            case 2:
                searchByName();
                APP();
                break;
            case 3:
                deleteByName();
                APP();
                break;
            case 4:
                updateByName();
                APP();
                break;
            case 5:
                printAllStu();
                APP();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("请输入1-6序号选择对应操作！");
                APP();
                break;
        }
    }
    
    private void printAllStu() {
        Collections.sort(stulist, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getId() - t1.getId();
            }
        });
        if(stulist.size()==0){
            System.out.println("当前暂无学生信息！");
            return;
        }
        System.out.println("当前所有学生信息如下：");
        for(Student stu : stulist){
            System.out.println(stu.toString());
        }
    }

    private void updateByName() {
        System.out.println("请输入你要更新信息的学生姓名：");
        int flag=0;
        String name = in.next();
        for(Student stu : stulist){
            if(stu.getName().equals(name)){
                flag=1;
                System.out.println("该学生当前信息： "+ stu.toString());
                System.out.println("请输入修改后的学号：");
                int id = in.nextInt();
                System.out.println("请输入修改后的姓名：");
                String name2 = in.next();
                System.out.println("请输入修改后的年龄：");
                String bir = in.next();
                System.out.println("请输入修改后的性别：");
                boolean gender = in.nextBoolean();
                stu.setId(id);
                stu.setName(name2);
                stu.setBirDate(bir);
                stu.setGender(gender);
                break;
            }
        }if(flag==0){
            System.out.println("暂无该姓名的学生，请重试！");
        }
        return;
    }

    private void deleteByName() {
        System.out.println("请输入你要删除的学生姓名：");
        int flag=0;
        String name = in.next();
        //判断该姓名学生是否存在
        for (Student stu : stulist){
            if(stu.getName().equals(name)){
                flag=1;
                stulist.remove(stu);
                break;
            }
        }
        if(flag==0){
            System.out.println("暂无该学生信息，请重试！");
        }return;
    }

    private void searchByName() {
        System.out.println("请输入你要查询的学生姓名：");
        String name = in.next();
        for(Student stu : stulist){
            if(stu.getName().equals(name)){
                System.out.println(stu.toString());
                return;
            }
        }
        System.out.println("暂无该姓名的学生，请重试！");
        return;
    }

    private void addStu() {
        System.out.println("请输入你想添加的学生信息：");
        System.out.println("学号：");
        int id = in.nextInt();
        for(Student st : stulist){
            if(Objects.equals(st.getId(), id)){
                System.out.println("该学号已存在，请重新输入！");
                return;
            }
        }
        System.out.println("姓名：");
        String name = in.next();
        System.out.println("生日：");
        String birDate = in.next();
        System.out.println("性别（true代表女，false代表男）：");
        boolean gender = in.nextBoolean();
        Student s = new Student(id,name,birDate,gender);
        stulist.add(s);
    }

}
