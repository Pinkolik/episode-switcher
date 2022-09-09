package io.github.pinkolik.episodeswitcher.alisa.dto.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum CapabilityType {
    ON_OFF("devices.capabilities.on_off"),
    RANGE("devices.capabilities.range");

    private static final Map<String, CapabilityType> NAMES_MAP = new HashMap<>();

    @Getter
    @JsonValue
    private final String name;

    static {
        NAMES_MAP.put("devices.capabilities.on_off", ON_OFF);
        NAMES_MAP.put("devices.capabilities.range", RANGE);
    }

    @JsonCreator
    public static CapabilityType forName(String name) {
        return NAMES_MAP.get(name);
    }
}
