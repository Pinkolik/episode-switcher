package io.github.pinkolik.episodeswitcher.alisa.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DeviceDto {

    private String id;

    private String name;

    private String description;

    private String room;

    private String type;

    private Map<String, Object> customData;

    private List<GetDevicesCapabilityDto> capabilities;

    private Map<String, String> properties;

    private DeviceInfoDto deviceInfo;
}
