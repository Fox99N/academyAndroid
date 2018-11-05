package com.fox.academy_lesson1.networking_news.dto;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsDTO {
     String status;
     String copyright;
     String section;
    @SerializedName("results")
     List<ResultDTO> resultDTO;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getSection() {
        return section;
    }

    public List<ResultDTO> getResultDTO() {
        return resultDTO;
    }
}

