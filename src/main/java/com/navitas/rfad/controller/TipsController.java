package com.navitas.rfad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class TipsController {

    private final TipsRepository tipsRepository;

    @Autowired
    public TipsController(TipsRepository tipsRepository) {
        this.tipsRepository = tipsRepository;
    }

    @PostMapping(value = "/tips/create/")
    public ResponseEntity<Tips> create(@RequestBody Tips tips) {
        return new ResponseEntity<>(tipsRepository.save(tips), HttpStatus.CREATED);
    }

}
