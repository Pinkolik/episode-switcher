package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.UnlinkUserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlisaServiceImpl implements AlisaService {

    @Override
    public UnlinkUserResponseDto unlinkUser(String requestId) {
        log.info("RequestId: {}", requestId);
        return new UnlinkUserResponseDto(requestId);
    }
}
