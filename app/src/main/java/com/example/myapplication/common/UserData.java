package com.example.myapplication.common;

public class UserData {

    private static String userNo;
    private static String userId;
    private static String userPw;
    private static String userName;
    private static String userEmail;
    private static String userYear;
    private static String userMonth;
    private static String userDay;

    public UserData(String userNo, String userId, String userPw,
                    String userName, String userEmail, String userYear, String userMonth, String userDay)
    {
        this.userNo = userNo;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userYear = userYear;
        this.userMonth = userMonth;
        this.userDay = userDay;
    }

    //region userNo
    public String GetNo()
    {
        return userNo;
    }

    public void SetNo(String userNo)
    {
        this.userNo = userNo;
    }
    //endregion

    //region userId
    public String GetId()
    {
        return userId;
    }

    public void SetId(String userId)
    {
        this.userId = userId;
    }
    //endregion

    //region userPw
    public String GetPw()
    {
        return userPw;
    }

    public void SetPw(String userPw)
    {
        this.userPw = userPw;
    }
    //endregion

    //region userName
    public String GetName()
    {
        return userName;
    }

    public void SetName(String userName)
    {
        this.userName = userName;
    }
    //endregion

    //region userEmail
    public String GetEmail()
    {
        return userEmail;
    }

    public void SetEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }
    //endregion

    //region userYear
    public String GetYear()
    {
        return userYear;
    }

    public void SetYear(String userYear)
    {
        this.userYear = userYear;
    }
    //endregion

    //region userMonth
    public String GetMonth()
    {
        return userMonth;
    }

    public void SetMonth(String userMoth)
    {
        this.userMonth = userMonth;
    }
    //endregion

    //region userDay
    public String GetDay()
    {
        return userDay;
    }

    public void SetDay(String userDay)
    {
        this.userDay = userDay;
    }
    //endregion




}
