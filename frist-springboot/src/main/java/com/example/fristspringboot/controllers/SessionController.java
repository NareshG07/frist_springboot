package com.example.fristspringboot.controllers;

import com.example.fristspringboot.models.Session;
import com.example.fristspringboot.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionController {


    public SessionRepository sessionRepository;

    @Autowired
    public void getSessionRepository(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Session> getById(@PathVariable Long id){
        return sessionRepository.findById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value= "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        //Also need to check for children records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        //because this is a PUT, we expect all attributes to be passes in, A PATCH would only need what to update
        //TODO: Add validation that all attributes are passsed in, otherwise return a 400 bad payload
        Session  existingSession=sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
