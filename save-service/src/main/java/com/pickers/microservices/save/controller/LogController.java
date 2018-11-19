package com.pickers.microservices.save.controller;

import com.pickers.microservices.save.model.LogModel;
import com.pickers.microservices.save.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired private LogService logService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("logs", logService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("add_form", "contact", new LogModel());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("log") LogModel logModel) {
        if(logModel.getId() == null) logService.add(logModel);
        else logService.update(logModel);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam() Long id) {
        return new ModelAndView("add_form", "log", logService.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam() Long id) {
        logService.remove(id);

        return "redirect:/";
    }

}

