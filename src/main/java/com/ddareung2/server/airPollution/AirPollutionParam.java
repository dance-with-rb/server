package com.ddareung2.server.airPollution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AirPollutionParam {
    @Value("${api.key.airPollution}")
    private String serviceKey;
    private final String returnType = "json";
    private final String dataTerm = "DAILY";
    private final String ver = "1.3";
    private String stationName;
    private int pageNo;
    private int numOfRows;
}
