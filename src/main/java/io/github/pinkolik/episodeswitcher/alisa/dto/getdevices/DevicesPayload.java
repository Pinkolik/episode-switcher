package io.github.pinkolik.episodeswitcher.alisa.dto.getdevices;

import lombok.Data;

import java.util.List;

@Data
public class DevicesPayload {

    private String userId;

    private List<Device> devices;

}
