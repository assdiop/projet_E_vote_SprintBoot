package com.forcen.e_vote.dtos;

import lombok.Data;

@Data
public class VoteDTO {
    private Long scrutinId;
    private Long candidatId;
    private Long electeurId;
}