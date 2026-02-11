package ua.opnu.springsecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.opnu.springsecurity.entity.Note;
import ua.opnu.springsecurity.service.NoteService;


@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView res = new ModelAndView("note/list");
        res.addObject("notes", noteService.listAll());
        return res;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam long id) {
        ModelAndView res = new ModelAndView("note/edit");
        res.addObject("note", noteService.getById(id));
        return res;
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}