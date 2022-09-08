package io.github.pinkolik.episodeswitcher.alisa.dto;

import lombok.Data;

import java.util.List;

@Data
public class DevicesPayloadDto {

    private String userId;

    private List<DeviceDto> devices;

}
