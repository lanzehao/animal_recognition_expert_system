package com.ramshow.ares.logic;

import com.ramshow.ares.lib.Database;
import com.ramshow.ares.lib.Rule;
import com.ramshow.ares.model.Knowledge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Inference {

    private static Database db = new Database();
    private static Map<Integer,String> dataMap = db.getDataMap();
    private static String featureStr = null;

    public static String anaylisis(String[] features) {
        //0.0将传入的字符串数组中的动物特征代号转存入List<Integer>中
        List<Integer> featureList = new ArrayList<>();
        for(String fStr : features){
            featureList.add(Integer.parseInt(fStr));
        }
        //0.1生成特征描述语句
        featureStr = featureDesc(featureList);

        //1.0将特征代号List(第一批事实)迭代处理，找到这批事实可以推断出的所有其他事实，直至不能发现新事实为止。
        List<Integer> matchedfeats = matchFeat(featureList);
        //2.0对比生成的事实List与全部动物数组，
        //如果数组中包含0个动物，则未识别到动物
        //如果数组中包含1个动物，输出识别到的动物
        //如果数组中包含多个动物，则未识别到具体动物，输出可能的动物
        Database db = new Database();
        int[] animals = db.getAnimals();
        List<Integer> animalRsList = new ArrayList<>();
        for(int num : animals){
            if(matchedfeats.contains(num)){
                animalRsList.add(num);
            }
        }
        //3.0解释器：生成输出语句
        return output(animalRsList);
    }

    private static String featureDesc(List<Integer> features) {
        StringBuilder sb = new StringBuilder();
        for(int feat : features){
            sb.append(dataMap.get(feat));
            sb.append("、");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static String output(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        int size = list.size();
        if(size==0){
            sb.append("未识别到符合输入条件(").append(featureStr).append(")的动物");
        }else if(size == 1){
            sb.append("识别到符合条件(").append(featureStr).append(")的动物：").append(dataMap.get(list.get(0)));
        }else{
            sb.append("识别到符合条件(").append(featureStr).append(")的动物可能为：");
            for(int num : list){
                sb.append(dataMap.get(num)).append("、");
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private static List<Integer> matchFeat(List<Integer> features) {
        //定义能从前一批事实中找到新事实的 新事实List
        List<Integer> matchedfeats = new ArrayList<>();
        Rule rule = new Rule();
        //获取所有规则List
        List<Knowledge> rules = rule.getRules();
        for(Knowledge K : rules){
            //根据已有事实和规则生成新事实
            produceFeatsByFeats(matchedfeats,K,features);
        }
        //若增加的新事实为0,则没有生成新事实，返回传入的事实List
        if(matchedfeats.size() == 0){
            return features;
        }else{
            //否则将传入的事实List加入新事实List中，迭代本方法
            matchedfeats.addAll(features);
            return matchFeat(matchedfeats);
        }
    }

    private static void produceFeatsByFeats(List<Integer> matchedfeats, Knowledge K, List<Integer> features) {
        boolean flag = true;
        int[] ifs = K.getIfs();
        for(int ifNum : ifs){
            if(!features.contains(ifNum)){
                flag = false;
            }
        }
        if(flag){
            if(!features.contains(K.getThen())){
                matchedfeats.add(K.getThen());
                System.out.println("发现新事实：" + dataMap.get(K.getThen()));
            }
        }
    }
}
