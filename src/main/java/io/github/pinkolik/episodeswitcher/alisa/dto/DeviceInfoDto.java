package io.github.pinkolik.episodeswitcher.alisa.dto;

import lombok.Data;

@Data
public class DeviceInfoDto {

    private String manufacturer;

    private String model;

    private String hwVersion;

    private String swVersion;
}
