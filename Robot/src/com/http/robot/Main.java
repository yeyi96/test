package com.http.robot;

import java.util.Scanner;

public class Main {
    private  static  final RobotService robotService = new QykRobotServiceImpl();

    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("老板，麻烦你给我娶个老婆，按回车结束");
        String name = scanner.nextLine();
        System.out.println("我是小助手" + name + "下达指令");
        while (true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("886")){
               System.out.println("拜拜");
               break;
            }else{
                Response response = robotService.qa(input);

                if (response.getCode() == 0){
                    System.out.println(name + ":" +response.getContent());
                }else{
                    System.out.println(name + ":" + "暂时不明白，请重试");
                }
            }
        }
        scanner.close();
        }
    }
