package io.github.pinkolik.episodeswitcher.alisa.dto;

import lombok.Data;

@Data
public class BaseResponseDto <T> {

    private String requestId;

    private T payload;
}
