package com.fox.academy_lesson1.networking_news.dto;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsDTO {
     String status;
     String copyright;
     String section;
     List<ResultDTO> results;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getSection() {
        return section;
    }

    public List<ResultDTO> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", section='" + section + '\'' +
                ", results=" + results +
                '}';
    }
}

