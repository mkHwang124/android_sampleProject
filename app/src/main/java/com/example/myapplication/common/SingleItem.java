package com.example.myapplication.common;

public class SingleItem {

    private String title = "";
    private String content = "";
    private int resId = 0;

    public SingleItem(String title, String content, int itemNumber)
    {
        this.title = title;
        this.content = content;
        this.resId = itemNumber;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return this.content;
    }

    public  void setContent(String content)
    {
        this.content = content;
    }

    public int getResId()
    {
        return this.resId;
    }

    public void setResId(int resId)
    {
        this.resId = resId;
    }


}
