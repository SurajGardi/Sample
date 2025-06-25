package com.marvellous.MarvellousPortal.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BatchDetails")
public class BatchEntry
{
    private ObjectId id;
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

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }
}
