package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.GetDevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.UnlinkUserResponseDto;

public interface AlisaService {

    GetDevicesResponseDto getDevices(String requestId);

    UnlinkUserResponseDto unlinkUser(String requestId);
}
