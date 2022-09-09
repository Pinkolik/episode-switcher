package io.github.pinkolik.episodeswitcher.alisa.dto.common.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum InstanceType {
    @JsonProperty("channel") CHANNEL("channel", null),
    @JsonProperty("volume") VOLUME("volume", Constants.PERCENT);

    @Getter
    @JsonValue
    private final String name;

    @Getter
    private final String unit;


    private static class Constants {

        public static final String PERCENT = "unit.percent";
    }
}
