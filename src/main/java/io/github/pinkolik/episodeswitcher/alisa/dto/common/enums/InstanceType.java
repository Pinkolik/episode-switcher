package io.github.pinkolik.episodeswitcher.alisa.dto.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum InstanceType {
    CHANNEL("channel", null),
    VOLUME("volume", Constants.PERCENT);

    private static final Map<String, InstanceType> NAMES_MAP = new HashMap<>();

    @Getter
    @JsonValue
    private final String name;

    @Getter
    private final String unit;

    static {
        NAMES_MAP.put("channel", CHANNEL);
        NAMES_MAP.put("volume", VOLUME);
    }

    @JsonCreator
    public static InstanceType forName(String name) {
        return NAMES_MAP.get(name);
    }

    private static class Constants {

        public static final String PERCENT = "unit.percent";
    }
}
