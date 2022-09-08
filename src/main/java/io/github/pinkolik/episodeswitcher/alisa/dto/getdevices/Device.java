package io.github.pinkolik.episodeswitcher.alisa.dto.getdevices;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.Capability;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Device {

    private String id;

    private String name;

    private String description;

    private String room;

    private String type;

    private Map<String, Object> customData;

    private List<Capability<?>> capabilities;

    private Map<String, String> properties;

    private DeviceInfo deviceInfo;
}
