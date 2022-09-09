package io.github.pinkolik.episodeswitcher.alisa.dto.common.state;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import lombok.Data;

@Data
public class State {

    private InstanceType instance;

    private Boolean relative;

    private Integer value;
}
