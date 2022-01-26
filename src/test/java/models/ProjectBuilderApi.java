package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBuilderApi {
    private String name;
    private String announcement;

    @SerializedName(value = "show_announcement")//переименование поля для процесса сериализации при использовании RestAssured ObjectMapperType.GSON
    private boolean isShowAnnouncement;

    @SerializedName(value = "suite_mode")//переименование поля для процесса сериализации при использовании RestAssured ObjectMapperType.GSON
    private int typeOfProject;

    @SerializedName(value = "is_completed")//переименование поля для процесса сериализации при использовании RestAssured ObjectMapperType.GSON
    private boolean isCompleted;

    }
