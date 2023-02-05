package com.example.fristspringboot.controllers;

import com.example.fristspringboot.models.Session;
import com.example.fristspringboot.models.Speaker;
import com.example.fristspringboot.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {


    @Autowired
    public SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAll(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Speaker>  getById(@RequestParam Long id){
        return speakerRepository.findById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value= "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        //Also need to check for children records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        //because this is a PUT, we expect all attributes to be passes in, A PATCH would only need what to update
        //TODO: Add validation that all attributes are passsed in, otherwise return a 400 bad payload
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
