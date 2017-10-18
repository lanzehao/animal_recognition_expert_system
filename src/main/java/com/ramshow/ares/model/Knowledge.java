package com.ramshow.ares.model;

import com.ramshow.ares.lib.Database;

import java.util.Map;

/**
 * Created by lanzehao on 2017/10/16.
 */
public class Knowledge {
    int[] ifs;
    int then;

    public Knowledge(int then, int...ifs){
        this.setIfs(ifs);
        this.setThen(then);
    }

    public int[] getIfs() {
        return ifs;
    }

    public void setIfs(int[] ifs) {
        this.ifs = ifs;
    }

    public int getThen() {
        return then;
    }

    public void setThen(int then) {
        this.then = then;
    }

    @Override
    public String toString(){
        Database db = new Database();
        Map<Integer, String> dataMap = db.getDataMap();
        StringBuilder sb = new StringBuilder();
        sb.append("规则：\n");
        sb.append("\t如果：");
        if(this.getIfs().length > 1){
            sb.append("动物").append(dataMap.get(this.ifs[0]));
            for(int i = 1; i < this.ifs.length; i++){
                sb.append("且").append(dataMap.get(this.ifs[i]));
            }
        }else{
            sb.append("动物").append(dataMap.get(this.ifs[0]));
        }
        sb.append("\n");
        sb.append("\t则：该动物是");
        sb.append(dataMap.get(this.then));
        return sb.toString();
    }
}
