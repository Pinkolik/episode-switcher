package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.UnlinkUserResponseDto;

public interface AlisaService {

    UnlinkUserResponseDto unlinkUser(String requestId);
}
