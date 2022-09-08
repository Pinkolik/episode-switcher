package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.*;
import io.github.pinkolik.episodeswitcher.util.KeycloakUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class AlisaServiceImpl implements AlisaService {

    private static final String DEVICE_DESCRIPTION = "Включает следующую серию сериала";

    private static final String DEVICE_ROOM = "Гостинная";

    private static final String DEVICE_TYPE = "devices.types.media_device.tv";

    private static final String DEVICE_ID = "0";

    private static final String DEVICE_NAME = "Кнопка включения следующей серии";

    @Override
    public GetDevicesResponseDto getDevices(String requestId) {
        log.info("RequestId: {}", requestId);
        GetDevicesResponseDto response = new GetDevicesResponseDto();
        response.setRequestId(requestId);

        DevicesPayloadDto payload = new DevicesPayloadDto();
        payload.setUserId(KeycloakUtils.getUserId());

        DeviceDto device = new DeviceDto();
        device.setId(DEVICE_ID);
        device.setName(DEVICE_NAME);
        device.setDescription(DEVICE_DESCRIPTION);
        device.setRoom(DEVICE_ROOM);
        device.setType(DEVICE_TYPE);
        device.setCustomData(null);

        GetDevicesCapabilityDto episodeSwitcherCapability = new GetDevicesCapabilityDto();
        episodeSwitcherCapability.setType("devices.capabilities.on_off"); // TODO: 9/8/22 Потом в енам
        episodeSwitcherCapability.setRetrievable(false);
        episodeSwitcherCapability.setReportable(false);
        GetDevicesCapabilityParametersDto parameters = new GetDevicesCapabilityParametersDto();
        parameters.setSplit(false);
        episodeSwitcherCapability.setParameters(parameters);
        device.setCapabilities(Collections.singletonList(episodeSwitcherCapability));

        device.setProperties(null);//TODO Сюда можно впихнуть текущую громкость, серию, и т.д.

        DeviceInfoDto deviceInfo = new DeviceInfoDto();
        deviceInfo.setManufacturer("pinkolik");
        deviceInfo.setModel("PC");
        deviceInfo.setHwVersion("1.0.0");
        deviceInfo.setSwVersion("0.0.1");
        device.setDeviceInfo(deviceInfo);

        payload.setDevices(Collections.singletonList(device));
        response.setPayload(payload);

        return null;
    }

    @Override
    public UnlinkUserResponseDto unlinkUser(String requestId) {
        log.info("RequestId: {}", requestId);
        UnlinkUserResponseDto response = new UnlinkUserResponseDto();
        response.setRequestId(requestId);
        return response;
    }
}
