package io.github.pinkolik.episodeswitcher.alisa.dto.common.capability;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.Parameters;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.state.State;
import lombok.Data;

@Data
public class Capability <T extends Parameters> {

    private Boolean retrievable;

    private Boolean reportable;

    private T parameters;

    private CapabilityType type;

    private State state;

    public CapabilityType getType() {
        return parameters == null ? null : parameters.getCapabilityType();
    }

    public void setType(CapabilityType type) {
        this.type = type;
    }
}
