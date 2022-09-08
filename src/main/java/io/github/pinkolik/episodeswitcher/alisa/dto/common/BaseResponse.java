package io.github.pinkolik.episodeswitcher.alisa.dto.common;

import lombok.Data;

@Data
public class BaseResponse <T> {

    private String requestId;

    private T payload;
}
