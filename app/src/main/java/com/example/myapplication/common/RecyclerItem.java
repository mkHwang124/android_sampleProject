package com.example.myapplication.common;

public class RecyclerItem {
    private String title = "";
    private String content = "";
    private int resId = 0;

    public RecyclerItem(String title, String content, int resId)
    {
        this.title = title;
        this.content = content;
        this.resId = resId;
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
