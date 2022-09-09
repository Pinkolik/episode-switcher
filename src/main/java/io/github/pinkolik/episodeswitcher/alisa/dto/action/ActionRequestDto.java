package io.github.pinkolik.episodeswitcher.alisa.dto.action;

import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesPayload;
import lombok.Data;

@Data
public class ActionRequestDto {

    private DevicesPayload payload;
}
