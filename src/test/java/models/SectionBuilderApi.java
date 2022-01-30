package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionBuilderApi {
    private String name;
    private int suite_id;
}
