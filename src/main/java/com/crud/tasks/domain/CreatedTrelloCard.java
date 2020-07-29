package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    @JsonProperty("badges")
    private TrelloBadgesDto badges;

    @JsonProperty("shortUrl")
    private String shortUrl;

    public CreatedTrelloCard(String id, String name, String shortUrl) {
        this.id = id;
        this.name = name;
        this.shortUrl = shortUrl;
        
    }
}
