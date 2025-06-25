package com.marvellous.MarvellousPortal.controller;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/batches")     // is applied only to the class => applied all things to the class
public class BatchEntryController
{
    private Map<Long, BatchEntry> batchentries = new HashMap<>();

    // HTTP : GET
    // R : Read
    // select * from batches;
    @GetMapping
    public List<BatchEntry> getAll()
    {
        return new ArrayList<>(batchentries.values());
    }

    // HTTP : POST
    // C : Create
    // insert into batches values(1,'PPA', 25000);
    @PostMapping
    public boolean createEntry(@RequestBody BatchEntry myentry)
    {
        batchentries.put(myentry.getId(),myentry);
        return true;
    }

    // HTTP : GET
    // R : Read
    // select * from batches where id = 1;
    @GetMapping("/id/{myid}")
    public BatchEntry getBatchEntryById(@PathVariable Long myid)
    {
        return batchentries.get(myid);
    }

    //********************************************************
    //HW - get data by name

    // HTTP : GET
    // R : Read
    // select * from batches where name = 'PPA';
    @GetMapping("/name/{name}")
    public BatchEntry getBatchEntryByName(@PathVariable String name)
    {
        for (BatchEntry obj : batchentries.values())
        {
            if (obj.getName().equals(name))
            {
                return obj;
            }
        }
        return null;
    }

    //HW - get data by MIN fees

    // HTTP : GET
    // R : Read
    // select * from batches where fees is minimum;
    @GetMapping("/minimum")
    public BatchEntry getBatchEntryByMinimumFees()
    {
        BatchEntry min = null;

        for (BatchEntry obj : batchentries.values())
        {
            if (min == null)
            {
                min = obj;
            }
            else if (obj.getFees() < min.getFees())
            {
                min = obj;
            }
        }
        return min;
    }

    //HW - get data by MAX fees

    // HTTP : GET
    // R : Read
    // select * from batches where fees is maximum;
    @GetMapping("/maximum")
    public BatchEntry getBatchEntryByMaximumFees()
    {
        BatchEntry max = null;

        for (BatchEntry obj : batchentries.values())
        {
            if (max == null)
            {
                max = obj;
            }
            else if (obj.getFees() > max.getFees())
            {
                max = obj;
            }
        }
        return max;
    }
    
    //******************************************************

    // HTTP : DELETE
    // D : Delete
    // delete from batches where id = 1;
    @DeleteMapping("/id/{myid}")
    public BatchEntry deleteEntryById(@PathVariable Long myid)
    {
        return  batchentries.remove(myid);
    }

    // HTTP : PUT
    // U : Update
    // update batches set fees = 30000 where id = 1;
    @PutMapping("/id/{myid}")
    public  BatchEntry updateEntryById(@PathVariable Long myid, BatchEntry myentry)
    {
        return batchentries.put(myid,myentry);
    }
}
