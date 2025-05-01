package com.bobocode.mvc.controller;

import com.bobocode.mvc.data.Notes;
import com.bobocode.mvc.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@link NoteController} is a typical controller that powers Spring MVC Notes application.
 * It provides the ability to show the list of notes and add a new note using a form.
 */
@Controller
@RequiredArgsConstructor
public class NoteController {

    private final Notes notes;

    /**
     * Handles the HTTP GET request to list all notes.
     *
     * @param model the model that contains the attributes to be passed to the view
     * @return the name of the Thymeleaf template to render
     */
    @GetMapping("/notes")
    public String getAllNotes(Model model) {
        model.addAttribute("noteList", notes.getAll()); // Adding the list of notes to the model
        return "notes"; // Returns the Thymeleaf template name (without extension)
    }

    /**
     * Handles the HTTP POST request to add a new note.
     *
     * @param title the title of the note
     * @param text the content of the note
     * @return the redirect URL to the notes page after the new note is added
     */
    @PostMapping("/notes")
    public String addNote(@RequestParam String title, @RequestParam String text) {
        notes.add(new Note(title, text)); // Add the new note to the storage
        return "redirect:/notes"; // Redirect to the GET /notes page to display the updated list
    }
}
