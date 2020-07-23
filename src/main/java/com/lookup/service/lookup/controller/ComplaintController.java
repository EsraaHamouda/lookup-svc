package com.lookup.service.lookup.controller;

import com.lookup.service.lookup.dao.ComplaintRepository;
import com.lookup.service.lookup.model.Complaint;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/complaint")
@Api(tags = "Complaint endpoints")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        complaintRepository.save(complaint);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable("uuid") String uuid) {
        Optional<Complaint> complaint = complaintRepository.findById(uuid);
        return complaint.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{uuid}")
    public ResponseEntity<List<Complaint>> getComplaintsByUserId(@PathVariable("uuid") String userUuid) {
        List<Complaint> result = complaintRepository.findByUserUuid(userUuid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Complaint>> listComplaints() {
        List<Complaint> result = complaintRepository.findAll();
        if (result.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public Complaint updateComplaint(@RequestBody Complaint complaint, @PathVariable("uuid") String uuid) {
        complaint.setUuid(uuid);
        complaintRepository.save(complaint);
        return complaint;
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteComplaintById(@PathVariable("uuid") String uuid) {
        complaintRepository.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }
}
