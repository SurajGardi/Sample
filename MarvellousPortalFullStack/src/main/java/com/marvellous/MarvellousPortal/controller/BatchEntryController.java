package com.marvellous.MarvellousPortal.controller;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import com.marvellous.MarvellousPortal.service.BatchEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    @Autowired
    private BatchEntryService batchEntryService;

    @GetMapping
    public List<BatchEntry> getAll()
    {
        return batchEntryService.getAll();
    }


    @PostMapping
    public String createEntry(@RequestBody BatchEntry myentry)
    {
        batchEntryService.saveEntry(myentry);
        return "Document inserted Succesfully";
    }


//    @GetMapping("/id/{myid}")
//    public Optional<BatchEntry> getBatchEntryById(@PathVariable ObjectId myid)
//    {
//        return batchEntryService.findById(myid);
//    }

    @GetMapping("/id/{myid}")
    public BatchEntry getBatchEntryById(@PathVariable ObjectId myid)
    {
        return batchEntryService.findById(myid).orElse(null);
    }


    @DeleteMapping("/id/{myid}")
    public boolean deleteEntryById(@PathVariable ObjectId myid)
    {
        batchEntryService.deleteByID(myid);
        return true;
    }


    @PutMapping("/id/{myid}")
    public void updateEntryById(@PathVariable Long myid, BatchEntry myentry)
    {
    }
}
