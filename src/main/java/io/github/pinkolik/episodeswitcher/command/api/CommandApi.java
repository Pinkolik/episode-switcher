package io.github.pinkolik.episodeswitcher.command.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface CommandApi {

    @PostMapping("/command")
    ResponseEntity<Void> command(@RequestBody String body);

    @GetMapping("/check")
    ResponseEntity<String> check();
}
