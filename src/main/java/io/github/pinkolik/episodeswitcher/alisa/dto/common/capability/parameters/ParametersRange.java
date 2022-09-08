package io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.Range;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import lombok.Data;

@Data
public class ParametersRange implements Parameters {

    private InstanceType instance;

    private boolean randomAccess;

    private Range range;

    @Override
    public CapabilityType getCapabilityType() {
        return CapabilityType.RANGE;
    }

    public String getUnit() {
        return instance == null ? null : instance.getName();
    }
}
