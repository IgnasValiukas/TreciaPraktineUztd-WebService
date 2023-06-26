package viko.eif.ivaliukas.lego.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viko.eif.ivaliukas.lego.rest.exception.ResourceNotFoundException;
import viko.eif.ivaliukas.lego.rest.model.Employee;
import viko.eif.ivaliukas.lego.rest.model.Lego;
import viko.eif.ivaliukas.lego.rest.model.LegoStore;
import viko.eif.ivaliukas.lego.rest.repository.LegoStoreRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/legostore")
public class LegoStoreController {
    @Autowired
    private LegoStoreRepository legoStoreRepository;

    @GetMapping
    public List<LegoStore> getAllLegoStores(){
        return legoStoreRepository.findAll();
    }

    @PostMapping
    public LegoStore createLegoStore(@RequestBody LegoStore legoStore){
        return legoStoreRepository.save(legoStore);
    }

    @GetMapping("{id}")
    public ResponseEntity<LegoStore> getLegoStoreById(@PathVariable long id){
        LegoStore legoStore = legoStoreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lego store not exist with id:" + id));
        return ResponseEntity.ok(legoStore);
    }

    @PutMapping("{id}")
    public ResponseEntity<LegoStore> updateLegoStore(@PathVariable long id, @RequestBody LegoStore legoStoreDetails){
        LegoStore updateLegoStore = legoStoreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lego store not exist with id:" + id));

        updateLegoStore.setStoreCountry(legoStoreDetails.getStoreCountry());
        updateLegoStore.setStoreCity(legoStoreDetails.getStoreCity());
        updateLegoStore.setStoreAddress(legoStoreDetails.getStoreAddress());
        updateLegoStore.setStorePhoneNumber(legoStoreDetails.getStorePhoneNumber());
        updateLegoStore.setAddressURL(legoStoreDetails.getAddressURL());

        legoStoreRepository.save(updateLegoStore);

        return ResponseEntity.ok(updateLegoStore);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteLegoStore(@PathVariable long id){
        LegoStore legoStore = legoStoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lego store not exist with id: " + id));

        legoStoreRepository.delete(legoStore);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
