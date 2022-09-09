package io.github.pinkolik.episodeswitcher.alisa.dto.common.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CapabilityType {
    @JsonProperty("devices.capabilities.on_off") ON_OFF("devices.capabilities.on_off"),
    @JsonProperty("devices.capabilities.range") RANGE("devices.capabilities.range");

    @Getter
    @JsonValue
    private final String name;

}
