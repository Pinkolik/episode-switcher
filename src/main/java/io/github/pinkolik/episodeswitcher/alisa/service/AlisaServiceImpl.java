package io.github.pinkolik.episodeswitcher.alisa.service;

import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.action.ActionResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.Range;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.Capability;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.ParametersOnOff;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.capability.parameters.ParametersRange;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.enums.InstanceType;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.state.ActionResult;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.state.State;
import io.github.pinkolik.episodeswitcher.alisa.dto.common.state.Status;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.Device;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DeviceInfo;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesPayload;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryRequestDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.query.QueryResponseDto;
import io.github.pinkolik.episodeswitcher.alisa.dto.unlinkuser.UnlinkUserResponseDto;
import io.github.pinkolik.episodeswitcher.client.dto.CommandDto;
import io.github.pinkolik.episodeswitcher.client.service.ClientService;
import io.github.pinkolik.episodeswitcher.util.KeycloakUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlisaServiceImpl implements AlisaService {

    private static final String DEVICE_DESCRIPTION = "Компьютер, на котором можно управлять сериалами";

    private static final String DEVICE_ROOM = "Зал";

    private static final String DEVICE_TYPE = "devices.types.media_device.tv";

    private static final String DEVICE_ID = "0";

    private static final String DEVICE_NAME = "Компьютер";

    private final ClientService clientService;

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
    public ActionResponseDto makeAction(String requestId, ActionRequestDto request) {
        log.info("RequestId: {}", requestId);
        log.info("Request: {}", request);
        ActionResponseDto response = new ActionResponseDto();
        response.setRequestId(requestId);
        DevicesPayload payload = new DevicesPayload();

        List<Device> devices = request.getPayload().getDevices();
        payload.setDevices(new ArrayList<>(devices.size()));
        for (Device device : devices) {
            Device deviceResponse = new Device();
            deviceResponse.setId(device.getId());
            List<Capability<?>> capabilities = device.getCapabilities();
            deviceResponse.setCapabilities(new ArrayList<>(capabilities.size()));
            for (Capability<?> capability : capabilities) {
                Capability<?> capabilityResponse = new Capability<>();
                capabilityResponse.setType(capability.getType());
                State state = capability.getState();
                State stateResponse = new State();
                stateResponse.setInstance(state.getInstance());
                ActionResult actionResult = new ActionResult();
                actionResult.setStatus(Status.DONE);
                stateResponse.setActionResult(actionResult);
                capabilityResponse.setState(stateResponse);
                deviceResponse.getCapabilities().add(capabilityResponse);
                CommandDto command = new CommandDto();
                command.setInstance(state.getInstance());
                command.setRelative(state.getRelative());
                command.setValue(state.getValue());
                clientService.putNextCommand(KeycloakUtils.getUserId(), command);
            }
            payload.getDevices().add(deviceResponse);
        }

        response.setPayload(payload);
        return response;
    }

    @Override
    public QueryResponseDto getDevicesStatus(String requestId, QueryRequestDto request) {
        log.info("RequestId: {}", requestId);
        log.info("Request: {}", request);
        QueryResponseDto response = new QueryResponseDto();
        response.setRequestId(requestId);

        DevicesPayload payload = new DevicesPayload();
        Device device = new Device();
        device.setId(DEVICE_ID);
        device.setCapabilities(Collections.emptyList());

        payload.setDevices(Collections.singletonList(device));

        response.setPayload(payload);
        return response;
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

        device.setProperties(null);

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
