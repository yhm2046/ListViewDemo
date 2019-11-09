package com.example.evan.liveviewdemo;

/**
 * Created by evan on 2019/11/9.
 */

public class Data {
    private String dTitle;
    private String dContent;
    private int dIcon;

    public Data(){}

    public void setdTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
    }

    public void setdIcon(int dIcon) {
        this.dIcon = dIcon;
    }

    public String getdTitle() {

        return dTitle;
    }

    public String getdContent() {
        return dContent;
    }

    public int getdIcon() {
        return dIcon;
    }

    public Data(String dTitle, String dContent, int dIcon){
        this.dTitle=dTitle;
        this.dContent=dContent;
        this.dIcon=dIcon;

    }

}
