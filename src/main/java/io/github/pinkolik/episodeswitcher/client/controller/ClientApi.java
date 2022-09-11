package io.github.pinkolik.episodeswitcher.client.controller;

import io.github.pinkolik.episodeswitcher.client.dto.CommandDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/client/v1.0")
public interface ClientApi {

    @GetMapping("/command")
    ResponseEntity<CommandDto> getNextCommand();

}
