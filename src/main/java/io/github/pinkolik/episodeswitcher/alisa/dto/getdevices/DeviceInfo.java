package io.github.pinkolik.episodeswitcher.alisa.dto.getdevices;

import lombok.Data;

@Data
public class DeviceInfo {

    private String manufacturer;

    private String model;

    private String hwVersion;

    private String swVersion;
}
