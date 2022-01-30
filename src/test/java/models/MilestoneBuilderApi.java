package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MilestoneBuilderApi {
    private String name;
    private String description;
    //private int parent_id;
    private String refs;

}
