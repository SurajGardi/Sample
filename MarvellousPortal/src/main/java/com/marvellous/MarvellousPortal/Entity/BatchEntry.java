package com.marvellous.MarvellousPortal.Entity;

public class BatchEntry
{
    private long id;
    private String name;
    private int fees;

    public int getFees()
    {
        return fees;
    }

    public void setFees(int fees)
    {
        this.fees = fees;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
