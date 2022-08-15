package com.example.testing.controller;

import com.example.testing.model.SimRequest;
import com.example.testing.model.SimResponse;
import com.example.testing.model.Sims;
import com.example.testing.service.ISimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimController {

    @Autowired
    ISimService simService;

    @PostMapping("/")
    public ResponseEntity response()
    {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SimResponse> createSim(@RequestBody SimRequest simRequest){
        return new ResponseEntity<>(simService.createSim(simRequest), HttpStatus.CREATED);
    }

    @GetMapping("/listall")
    public ResponseEntity<Sims> fetchAllSims(){
        return new ResponseEntity<>(simService.fetchAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimResponse> updateRecord(@PathVariable(name = "id") Long id, @RequestBody SimRequest simRequest ){
        try {
            return new ResponseEntity<>(simService.updateRecord(id, simRequest), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeRecord(@PathVariable(name = "id") Long id){
        try {
            simService.deleteRecord(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/to-renew")
    public ResponseEntity findAllRecordsToBeRenewed(){
        return new ResponseEntity(simService.findAllRecordsToBeRenewed(), HttpStatus.OK);
    }

    @PutMapping("/renew/{id}")
    public ResponseEntity renewPack(@PathVariable(name = "id") Long id){
        try{
            simService.renewPack(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
