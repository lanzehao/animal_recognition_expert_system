package com.ramshow.ares.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Database {

    public static Map<Integer, String> dataMap = new HashMap<>();

    public static int[] animals;


    public Map<Integer, String> getDataMap() {
        return this.dataMap;
    }

    public int[] getAnimals() {
        return this.animals;
    }

    public Database(){
        initDatabase();
        animals = initAnimalsArr();
    }

    private void initDatabase(){
        dataMap.put(1,"反刍动物");
        dataMap.put(2,"蹄类动物");
        dataMap.put(3,"哺乳动物");
        dataMap.put(4,"目视前方");
        dataMap.put(5,"有爪");
        dataMap.put(6,"有犬齿");
        dataMap.put(7,"吃肉");
        dataMap.put(8,"下蛋");
        dataMap.put(9,"不会飞");
        dataMap.put(10,"有羽毛");
        dataMap.put(11,"有蹄");
        dataMap.put(12,"肉食动物");
        dataMap.put(13,"鸟类");
        dataMap.put(14,"产奶");
        dataMap.put(15,"有毛发");
        dataMap.put(16,"善飞");
        dataMap.put(17,"黑白色");
        dataMap.put(18,"会游泳");
        dataMap.put(19,"长腿");
        dataMap.put(20,"长脖子");
        dataMap.put(21,"有黑色条纹");
        dataMap.put(22,"有暗斑点");
        dataMap.put(23,"黄褐色");
        dataMap.put(24,"信天翁");
        dataMap.put(25,"企鹅");
        dataMap.put(26,"鸵鸟");
        dataMap.put(27,"斑马");
        dataMap.put(28,"长颈鹿");
        dataMap.put(29,"老虎");
        dataMap.put(30,"猎豹");
    }

    private int[] initAnimalsArr() {
        int[] animals =  new int[7];
        for(int i = 0; i<animals.length; i++){
            animals[i] = i+24;
        }
        return animals;
    }

    public static void outputAllFeatures(){
        for(int i = 1; i < 24; i++){
            if(i%4==0){
                System.out.println(i+":"+dataMap.get(i));
            }else{
                System.out.print(i+":"+dataMap.get(i));
                if(i<23){
                    System.out.print(", ");
                }else{
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        outputAllFeatures();
    }

}
