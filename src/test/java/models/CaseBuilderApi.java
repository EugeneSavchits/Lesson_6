package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseBuilderApi {
    private String title;
    private int priority_id;

}
