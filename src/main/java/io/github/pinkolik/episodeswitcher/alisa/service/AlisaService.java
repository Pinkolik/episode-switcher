package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;

public interface AlisaService {

    DevicesResponseDto getDevices(String requestId);

    UnlinkUserResponseDto unlinkUser(String requestId);
}
