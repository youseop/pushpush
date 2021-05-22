package com.pushpush.server.web.major;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class RankingDto {
    private String username;
    private Integer point;
}
