package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.Range;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.Capability;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.ParametersOnOff;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.ParametersRange;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.Device;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DeviceInfo;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesPayload;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;
import io.github.pinkolik.episodeswitcher.util.KeycloakUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Service
public class AlisaServiceImpl implements AlisaService {

    private static final String DEVICE_DESCRIPTION = "Компьютер, на котором можно управлять сериалами";

    private static final String DEVICE_ROOM = "Зал";

    private static final String DEVICE_TYPE = "devices.types.media_device.tv";

    private static final String DEVICE_ID = "0";

    private static final String DEVICE_NAME = "Компьютер";

    private Capability<ParametersOnOff> getOnOffCapability() {
        Capability<ParametersOnOff> capability = new Capability<>();
        capability.setRetrievable(false);
        capability.setReportable(false);
        ParametersOnOff parameters = new ParametersOnOff();
        parameters.setSplit(false);
        capability.setParameters(parameters);
        return capability;
    }

    private Capability<ParametersRange> getChannelsCapability() {
        Capability<ParametersRange> capability = new Capability<>();
        capability.setRetrievable(false);
        capability.setReportable(false);
        ParametersRange parameters = new ParametersRange();
        parameters.setInstance(InstanceType.CHANNEL);
        parameters.setRandomAccess(false);
        capability.setParameters(parameters);
        return capability;
    }

    private Capability<ParametersRange> getVolumeCapability() {
        Capability<ParametersRange> capability = new Capability<>();
        capability.setRetrievable(false);
        capability.setReportable(false);
        ParametersRange parameters = new ParametersRange();
        parameters.setInstance(InstanceType.VOLUME);
        parameters.setRandomAccess(false);
        Range range = new Range();
        range.setMin(0f);
        range.setMax(100f);
        range.setPrecision(10f);
        parameters.setRange(range);
        capability.setParameters(parameters);
        return capability;
    }

    @Override
    public DevicesResponseDto getDevices(String requestId) {
        log.info("RequestId: {}", requestId);
        DevicesResponseDto response = new DevicesResponseDto();
        response.setRequestId(requestId);

        DevicesPayload payload = new DevicesPayload();
        payload.setUserId(KeycloakUtils.getUserId());

        Device device = new Device();
        device.setId(DEVICE_ID);
        device.setName(DEVICE_NAME);
        device.setDescription(DEVICE_DESCRIPTION);
        device.setRoom(DEVICE_ROOM);
        device.setType(DEVICE_TYPE);
        device.setCustomData(null);

        device.setCapabilities(Arrays.asList(getChannelsCapability(), getVolumeCapability()));

        device.setProperties(null);//TODO Сюда можно впихнуть текущую громкость, серию, и т.д.

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setManufacturer("pinkolik");
        deviceInfo.setModel("PC");
        deviceInfo.setHwVersion("1.0.0");
        deviceInfo.setSwVersion("0.0.1");
        device.setDeviceInfo(deviceInfo);

        payload.setDevices(Collections.singletonList(device));
        response.setPayload(payload);

        return response;
    }

    @Override
    public UnlinkUserResponseDto unlinkUser(String requestId) {
        log.info("RequestId: {}", requestId);
        UnlinkUserResponseDto response = new UnlinkUserResponseDto();
        response.setRequestId(requestId);
        return response;
    }
}
