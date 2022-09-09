package io.github.pinkolik.episodeswitcher.alisa.dto.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.CapabilityType;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.state.State;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.Device;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesPayload;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {JacksonAutoConfiguration.class})
class ActionRequestDtoDeserializationTest {

    private static final String SAMPLE_REQUEST = """
                                                 {
                                                       "payload": {
                                                         "devices": [{
                                                                 "id": "lamp-001-xdl",
                                                                 "custom_data": {
                                                                     "api_location": "rus"
                                                                 },
                                                                 "capabilities": [{
                                                                     "type": "devices.capabilities.range",
                                                                     "state": {
                                                                         "instance": "channel",
                                                                         "value": 15
                                                                     }
                                                                 }]
                                                             },
                                                             {
                                                                 "id": "lamp-002-xdl",
                                                                 "custom_data": {
                                                                     "api_location": "rus"
                                                                 },
                                                                 "capabilities": [{
                                                                     "type": "devices.capabilities.range",
                                                                     "state": {
                                                                         "instance": "volume",
                                                                         "relative": true,
                                                                         "value": 10
                                                                     }
                                                                 }]
                                                             }
                                                         ]
                                                       }
                                                     }
                                                 """;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void deserializeTest() throws JsonProcessingException {
        ActionRequestDto actionRequestDto = mapper.readValue(SAMPLE_REQUEST, ActionRequestDto.class);
        log.info("Result: {}", actionRequestDto);

        DevicesPayload payload = actionRequestDto.getPayload();
        Assertions.assertNotNull(payload);
        List<Device> devices = payload.getDevices();
        Assertions.assertEquals(2, devices.size());
        Device lamp1 = devices.get(0);
        Device lamp2 = devices.get(1);
        Assertions.assertEquals("rus", lamp1.getCustomData().get("api_location"));
        Assertions.assertEquals("rus", lamp2.getCustomData().get("api_location"));
        Assertions.assertEquals(1, lamp1.getCapabilities().size());
        Assertions.assertEquals(1, lamp2.getCapabilities().size());
        Assertions.assertEquals(CapabilityType.RANGE, lamp1.getCapabilities().get(0).getType());
        Assertions.assertEquals(CapabilityType.RANGE, lamp2.getCapabilities().get(0).getType());
        State state1 = lamp1.getCapabilities().get(0).getState();
        State state2 = lamp2.getCapabilities().get(0).getState();
        Assertions.assertEquals(InstanceType.CHANNEL, state1.getInstance());
        Assertions.assertEquals(InstanceType.VOLUME, state2.getInstance());
        Assertions.assertNull(state1.getRelative());
        Assertions.assertEquals(true, state2.getRelative());
        Assertions.assertEquals(15, state1.getValue());
        Assertions.assertEquals(10, state2.getValue());
    }

}