package com.journalapplication.journalapplication.controller;

import com.journalapplication.journalapplication.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("{myId}")
    public JournalEntry editJournalEntryById(@PathVariable long myId, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(myId, myEntry);
    }

}