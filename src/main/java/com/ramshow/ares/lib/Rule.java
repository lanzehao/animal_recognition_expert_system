package com.ramshow.ares.lib;

import com.ramshow.ares.model.Knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Rule {
    public List<Knowledge> rules = new ArrayList<>();

    public List<Knowledge> getRules() {
        return rules;
    }

    public Rule(){
       init();
    }

    private void init(){
        this.rules.add(new Knowledge(3,15));//哺乳动物
        this.rules.add(new Knowledge(3,14));//哺乳动物
        this.rules.add(new Knowledge(13,10));//鸟类
        this.rules.add(new Knowledge(13,16,8));//鸟类
        this.rules.add(new Knowledge(12,7));//肉食动物
        this.rules.add(new Knowledge(12,6,5,4));//肉食动物
        this.rules.add(new Knowledge(2,3,11));//蹄类动物
        this.rules.add(new Knowledge(2,3,1));//蹄类动物
        this.rules.add(new Knowledge(30,3,12,23,22));//猎豹
        this.rules.add(new Knowledge(29,3,12,23,21));//老虎
        this.rules.add(new Knowledge(28,22,19,20,2));//长颈鹿
        this.rules.add(new Knowledge(27,21,2));//斑马
        this.rules.add(new Knowledge(26,19,20,17,13,9));//鸵鸟
        this.rules.add(new Knowledge(25,13,9,18,17));//企鹅
        this.rules.add(new Knowledge(24,13,16));//信天翁
    }

}
