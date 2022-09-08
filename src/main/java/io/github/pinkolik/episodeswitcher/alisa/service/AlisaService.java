package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.GetDevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;

public interface AlisaService {

    GetDevicesResponseDto getDevices(String requestId);

    UnlinkUserResponseDto unlinkUser(String requestId);
}
