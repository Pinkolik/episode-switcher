package io.github.pinkolik.episodeswitcher.alisa.controller;

import io.github.pinkolik.episodeswitcher.alisa.dto.UnlinkUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/alisa/v1.0")
public interface AlisaApi {

    @RequestMapping(method = RequestMethod.HEAD)
    ResponseEntity<Void> checkAvailability();

    @PostMapping("/user/unlink")
    ResponseEntity<UnlinkUserResponseDto> unlinkUser(@RequestHeader("X-Request-Id") String requestId);
}
