package viko.eif.ivaliukas.lego.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viko.eif.ivaliukas.lego.rest.exception.ResourceNotFoundException;
import viko.eif.ivaliukas.lego.rest.model.Lego;
import viko.eif.ivaliukas.lego.rest.repository.LegoRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/legos")
public class LegoController {
    @Autowired
    private LegoRepository legoRepository;

    @GetMapping
    public List<Lego> getAllLegos(){
        return legoRepository.findAll();
    }

    @PostMapping
    public Lego createLego(@RequestBody Lego lego){
        return legoRepository.save(lego);
    }

    @GetMapping("{id}")
    public ResponseEntity<Lego> getLegoById(@PathVariable long id){
        Lego lego = legoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lego not exist with id:" + id));
        return ResponseEntity.ok(lego);
    }

    @PutMapping("{id}")
    public ResponseEntity<Lego> updateLego(@PathVariable long id, @RequestBody Lego legoDetails){
        Lego updateLego = legoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lego not exist with id:" + id));

        updateLego.setName(legoDetails.getName());
        updateLego.setLegoNumber(legoDetails.getLegoNumber());
        updateLego.setPieceCount(legoDetails.getPieceCount());
        updateLego.setPrice(legoDetails.getPrice());
        updateLego.setAge(legoDetails.getAge());
        updateLego.setLegoStore(legoDetails.getLegoStore());

        legoRepository.save(updateLego);

        return ResponseEntity.ok(updateLego);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteLego(@PathVariable long id){
        Lego lego = legoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lego not exist with id: " + id));

        legoRepository.delete(lego);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
