package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoveCasesToSectionApi {
    private int section_id;
    private int suite_id;
    private int[] case_ids[];
}
