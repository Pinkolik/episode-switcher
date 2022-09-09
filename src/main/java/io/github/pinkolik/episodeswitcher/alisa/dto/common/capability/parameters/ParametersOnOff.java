package io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import lombok.Data;

@Data
public class ParametersOnOff implements Parameters {

    private Boolean split;

    @Override
    public CapabilityType getCapabilityType() {
        return CapabilityType.ON_OFF;
    }
}
