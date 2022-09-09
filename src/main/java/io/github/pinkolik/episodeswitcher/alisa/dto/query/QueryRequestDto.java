package io.github.pinkolik.episodeswitcher.alisa.dto.query;

import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.Device;
import lombok.Data;

import java.util.List;

@Data
public class QueryRequestDto {

    private List<Device> devices;
}
