package io.github.pinkolik.episodeswitcher.alisa.dto.query;

import io.github.pinkolik.episodeswitcher.alisa.dto.common.BaseResponse;
import io.github.pinkolik.episodeswitcher.alisa.dto.getdevices.DevicesPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryResponseDto extends BaseResponse<DevicesPayload> {}
