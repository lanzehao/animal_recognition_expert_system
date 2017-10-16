package com.ramshow.ares.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class database {

    public static Map<Integer, String> map = new HashMap<>();

    database(){
        initDatabase();
    }

    void initDatabase(){
        map.put(1,"反刍动物");
        map.put(2,"蹄类动物");
        map.put(3,"哺乳动物");
        map.put(4,"目视前方");
        map.put(5,"有爪");
        map.put(6,"有犬齿");
        map.put(7,"吃肉");
        map.put(8,"下蛋");
        map.put(9,"会飞");
        map.put(10,"有羽毛");
        map.put(11,"有蹄");
        map.put(12,"肉食动物");
        map.put(13,"鸟类");
        map.put(14,"产奶");
        map.put(15,"有毛发");
        map.put(16,"善飞");
        map.put(17,"黑白色");
        map.put(18,"会游泳");
        map.put(19,"长腿");
        map.put(20,"长脖子");
        map.put(21,"有黑色条纹");
        map.put(22,"有暗斑点");
        map.put(23,"黄褐色");
        map.put(24,"信天翁");
        map.put(25,"企鹅");
        map.put(26,"鸵鸟");
        map.put(27,"斑马");
        map.put(28,"长颈鹿");
        map.put(29,"老虎");
        map.put(30,"猎豹");
    }

}
