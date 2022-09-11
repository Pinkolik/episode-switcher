package io.github.pinkolik.episodeswitcher.client.dto;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import lombok.Data;

@Data
public class CommandDto {

    private InstanceType instance;

    private Boolean relative;

    private Integer value;
}
