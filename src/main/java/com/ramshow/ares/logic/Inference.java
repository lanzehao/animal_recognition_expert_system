package com.ramshow.ares.logic;

import com.ramshow.ares.lib.Rule;
import com.ramshow.ares.model.Knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Inference {

    public static String anaylisis(String[] features) {
        List<Integer> matchedfeats = matchFeat(features);

        return null;
    }

    private static List<Integer> matchFeat(String[] features) {
        List<Integer> matchedfeats = new ArrayList<>();
        Rule rule = new Rule();
        List<Knowledge> rules = rule.getRules();
        for(Knowledge K : rules){
            produceFeatsByFeats();
        }
        return null;
    }

    private static void produceFeatsByFeats() {
    }
}
