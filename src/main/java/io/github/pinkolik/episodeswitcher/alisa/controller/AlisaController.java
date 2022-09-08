package io.github.pinkolik.episodeswitcher.alisa.controller;

import io.github.pinkolik.episodeswitcher.alisa.dto.GetDevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.UnlinkUserResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.service.AlisaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AlisaController implements AlisaApi {

    private final AlisaService alisaService;

    @Override
    public ResponseEntity<Void> checkAvailability() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UnlinkUserResponseDto> unlinkUser(String requestId) {
        return ResponseEntity.ok(alisaService.unlinkUser(requestId));
    }

    @Override
    public ResponseEntity<GetDevicesResponseDto> getDevices(String requestId) {
        return ResponseEntity.ok(alisaService.getDevices(requestId));
    }
}
