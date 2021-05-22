package com.pushpush.server.web.major;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class RankingDtoWrapper {
    List<RankingDto> data;
}
