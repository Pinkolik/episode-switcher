package io.github.pinkolik.episodeswitcher.alisa.dto;

import lombok.Data;

import java.util.Map;

@Data
public class GetDevicesCapabilityDto {

    private String type;

    private boolean retrievable;

    private boolean reportable;

    private GetDevicesCapabilityParametersDto parameters;
}
