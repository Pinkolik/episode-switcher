package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;

public interface AlisaService {

    QueryResponseDto getDevicesStatus(String requestId, QueryRequestDto request);

    DevicesResponseDto getDevices(String requestId);

    UnlinkUserResponseDto unlinkUser(String requestId);
}
