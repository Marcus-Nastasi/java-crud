package com.rest.app.api.Controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rest.app.api.Models.Workers;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest.app.api.Repo.WorkerRepo;

import java.util.List;

@RestController
public class Home {

    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping(value = "/")
    public String gatHome() {
      return "Olá novamente!";
    };

    @GetMapping(value = "/api/workers")
    public List<Workers> getWorkers() {
        return workerRepo.findAll();
    };

    @PostMapping(value = "/api/workers/create")
    public String saveWorker(@RequestBody Workers workers) {
        workerRepo.save(workers);
        return "status: ok";
    };

    @PutMapping(value = "/api/update/{id}")
    public String update(@PathVariable long id, @RequestBody Workers workers) {
        Workers updateWorker = workerRepo.findById(id).get();
        updateWorker.setNome(workers.getNome());
        updateWorker.setSobrenome(workers.getSobrenome());
        updateWorker.setIdade(workers.getIdade());
        updateWorker.setCargo(workers.getCargo());
        workerRepo.save(updateWorker);
        return "updated";
    };

    @DeleteMapping(value = "/api/delete/{id}")
    public String delete(@PathVariable long id, @RequestBody Workers workers) {
        workerRepo.deleteById(id);
        return "sucesfully deleted";
    };

}


