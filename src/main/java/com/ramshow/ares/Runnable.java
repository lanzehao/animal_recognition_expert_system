package com.ramshow.ares;

import com.ramshow.ares.lib.Database;
import com.ramshow.ares.logic.Inference;
import java.util.Scanner;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Runnable {

    public static void main(String[] args){

        while(true){
            String input = request();
            if(ALL_FEATURES.equals(input)){
                System.out.println(ALL_FEATURES+ " List:");
                Database db = new Database();
                db.outputAllFeatures();
            }else{
                String[] features = input.split(" ");
                System.out.println(Inference.anaylisis(features));
                break;
            }
        }
    }

    private static final String ALL_FEATURES = "\\allFeat";

    private static String request(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入动物特征【代号】(中间加空格，Enter键结束，输入"+ALL_FEATURES+"获取特征列表)：");
        return scan.nextLine();
    }

}
