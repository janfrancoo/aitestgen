package com.janfranco.aitestgen.controller;

import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;
import com.janfranco.aitestgen.service.AddService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
@RequiredArgsConstructor
public class AddController {
    private final AddService addService;

    @PostMapping
    public ResponseEntity<AddResponse> add(@RequestBody AddRequest request) {
        AddResponse response = addService.add(request);
        return ResponseEntity.ok(response);
    }
}
