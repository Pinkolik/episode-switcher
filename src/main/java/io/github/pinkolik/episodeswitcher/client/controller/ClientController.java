package io.github.pinkolik.episodeswitcher.client.controller;

import io.github.pinkolik.episodeswitcher.client.dto.CommandDto;
import io.github.pinkolik.episodeswitcher.client.service.ClientService;
import io.github.pinkolik.episodeswitcher.util.KeycloakUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<CommandDto> getNextCommand() {
        return ResponseEntity.ok(clientService.getNextCommand(KeycloakUtils.getUserId()));
    }
}
