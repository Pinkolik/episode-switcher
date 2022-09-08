package io.github.pinkolik.episodeswitcher.alisa.dto.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CapabilityType {
    ON_OFF("devices.capabilities.on_off"),
    RANGE("devices.capabilities.range");

    @Getter
    @JsonValue
    private final String name;
}
