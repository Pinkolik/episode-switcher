package io.github.pinkolik.episodeswitcher.client.service;

import io.github.pinkolik.episodeswitcher.client.dto.CommandDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final Map<String, Queue<CommandDto>> userIdCommandMap = new ConcurrentHashMap<>();

    @Override
    public CommandDto getNextCommand(String userId) {
        return Optional.ofNullable(userIdCommandMap.getOrDefault(userId, null)).map(Queue::poll).orElse(null);
    }

    @Override
    public void putNextCommand(String userId, CommandDto command) {
        Queue<CommandDto> queue = userIdCommandMap.computeIfAbsent(userId, key -> new ConcurrentLinkedQueue<>());
        queue.add(command);
    }
}
