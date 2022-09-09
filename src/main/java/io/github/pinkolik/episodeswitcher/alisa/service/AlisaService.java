package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;

public interface AlisaService {

    ActionResponseDto makeAction(String requestId, ActionRequestDto request);

    QueryResponseDto getDevicesStatus(String requestId, QueryRequestDto request);

    DevicesResponseDto getDevices(String requestId);

    UnlinkUserResponseDto unlinkUser(String requestId);
}
