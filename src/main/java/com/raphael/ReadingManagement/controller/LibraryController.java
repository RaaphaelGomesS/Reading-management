package com.raphael.ReadingManagement.controller;

import com.raphael.ReadingManagement.dto.LibraryResponseDTO;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController(value = "/library")
public class LibraryController {

    private LibraryService libraryService;

//    @GetMapping("/")
//    private ResponseEntity<List<LibraryResponseDTO>> getAllLibrary(@RequestHeader String token) {
//
//
//
//    }

    @PostMapping("/create")
    private ResponseEntity<LibraryResponseDTO> createLibrary(@RequestParam String name, @RequestHeader String token) {

        //TODO adicionar validação do token para fazer busca da biblioteca do usuário específico

        Reader reader = new Reader();

        Library library = libraryService.createLibrary(name, reader);

        return ResponseEntity.ok(new LibraryResponseDTO(library.getName(), new ArrayList<>()));
    }

//    @PutMapping("/")
//    private ResponseEntity<LibraryResponseDTO> updateLibrary(@RequestParam String name) {
//
//    }

    @DeleteMapping("/delete/{name}")
    private ResponseEntity<String> deleteLibrary(@PathVariable("name") String name, @RequestHeader String token) {

        //TODO adicionar validação do token para fazer busca da biblioteca do usuário específico

        Reader reader = new Reader();

        libraryService.deleteLibrary(name, reader);

        return ResponseEntity.ok("A biblioteca + + foi deletada!");
    }
}
