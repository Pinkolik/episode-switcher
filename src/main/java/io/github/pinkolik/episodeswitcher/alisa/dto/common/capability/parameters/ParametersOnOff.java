package io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import lombok.Data;

@Data
public class ParametersOnOff implements Parameters {

    private boolean split;

    @Override
    public CapabilityType getCapabilityType() {
        return CapabilityType.ON_OFF;
    }
}
