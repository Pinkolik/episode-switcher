package io.github.pinkolik.episodeswitcher.alisa.dto.common.capability;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.Parameters;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import lombok.Data;

@Data
public class Capability <T extends Parameters> {

    private boolean retrievable;

    private boolean reportable;

    private T parameters;

    private CapabilityType type;

    private int value;

    private boolean relative;

    public CapabilityType getType() {
        return parameters == null ? null : parameters.getCapabilityType();
    }
}
