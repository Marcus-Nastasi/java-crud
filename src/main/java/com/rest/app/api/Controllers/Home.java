package com.rest.app.api.Controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rest.app.api.Models.Workers;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest.app.api.Repo.WorkerRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class Home {

    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping(value = "/")
    public String getHome() {
      return "Wellcome to RESTful API!";
    };

    @GetMapping(value = "/api/workers")
    public List<Workers> getWorkers() {
        return workerRepo.findAll();
    };

    @GetMapping(value = "/api/workers/{id}")
    public Optional<Workers> getSingle(@PathVariable long id) {
        return workerRepo.findById(id);
    };

    @PostMapping(value = "/api/workers/create")
    public void saveWorker(@RequestBody Workers newWorker) {
        workerRepo.save(newWorker);
    };

    @PutMapping(value = "/api/update/{id}")
    public void update(@PathVariable long id, @RequestBody Workers worker) {
        Workers updateWorker = workerRepo.findById(id).get();
        updateWorker.setNome(worker.getNome());
        updateWorker.setSobrenome(worker.getSobrenome());
        updateWorker.setIdade(worker.getIdade());
        updateWorker.setCargo(worker.getCargo());
        workerRepo.save(updateWorker);
    };

    @DeleteMapping(value = "/api/delete/{id}")
    public void delete(@PathVariable long id) {
        workerRepo.deleteById(id);
    };

}


