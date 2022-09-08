package io.github.pinkolik.episodeswitcher.alisa.controller;

import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/alisa/v1.0")
public interface AlisaApi {

    @RequestMapping(method = RequestMethod.HEAD)
    ResponseEntity<Void> checkAvailability();

    @PostMapping("/user/unlink")
    ResponseEntity<UnlinkUserResponseDto> unlinkUser(@RequestHeader("X-Request-Id") String requestId);

    @GetMapping("/user/devices")
    ResponseEntity<DevicesResponseDto> getDevices(@RequestHeader("X-Request-Id") String requestId);

    @PostMapping("/user/devices/action")
    ResponseEntity<ActionResponseDto> makeAction(@RequestHeader("X-Request-Id") String requestId, @RequestBody ActionRequestDto request);
}
