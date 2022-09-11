package io.github.pinkolik.episodeswitcher.client.service;

import io.github.pinkolik.episodeswitcher.client.dto.CommandDto;

public interface ClientService {

    CommandDto getNextCommand(String userId);

    void putNextCommand(String userId, CommandDto command);
}
