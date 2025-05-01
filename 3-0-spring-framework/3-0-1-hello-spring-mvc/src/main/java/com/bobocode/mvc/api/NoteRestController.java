package com.bobocode.mvc.api;

import com.bobocode.mvc.data.Notes;
import com.bobocode.mvc.model.Note;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This controller provides a simple REST API for Notes.
 * It implements two endpoints: one for retrieving all notes and one for adding a new note.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notes")
public class NoteRestController {

    private final Notes notes;

    /**
     * Handles the HTTP GET request to get all notes.
     *
     * @return a list of all notes in JSON format
     */
    @GetMapping
    public List<com.bobocode.mvc.model.Note> getAllNotes() {
        return notes.getAll(); // Return all notes as JSON
    }

    /**
     * Handles the HTTP POST request to add a new note.
     *
     * @param note the note to be added
     * @return the response status
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Returns 201 Created status
    public void addNote(@RequestBody Note note) {
        notes.add(note); // Add the note to the storage
    }
}
