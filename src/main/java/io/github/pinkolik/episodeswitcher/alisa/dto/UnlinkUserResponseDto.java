package io.github.pinkolik.episodeswitcher.alisa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnlinkUserResponseDto {

    @JsonProperty("request_id")
    private String requestId;
}
