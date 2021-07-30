package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.dataRepos.SkillRepository;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String index(Model model){

        model.addAttribute("title", "Skills");
        model.addAttribute("skills", skillRepository.findAll());

        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId){

        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if(optionalSkill.isPresent()){
            Skill skill = optionalSkill.get();
//            model.addAttribute("title", skill.getName());
            model.addAttribute("skill", skill);
            return "skills/view";
        }else{
//            model.addAttribute("skills", skillRepository.findAll());
            return "redirect:../";
        }
    }
}
