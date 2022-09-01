package io.github.pinkolik.episodeswitcher.command.impl;

import io.github.pinkolik.episodeswitcher.command.api.CommandApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommandController implements CommandApi {

    @Override
    public ResponseEntity<Void> command(String body) {
        log.info(body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Чек, чек, чек. Левое ухо, левое. Правоу ухо, правое. Стерео");
    }
}
