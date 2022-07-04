package kr.gmtc.resttest.model.iss;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @SerializedName("no") protected Integer no;
    @SerializedName("alternativePath") protected Integer alternativePath;
    @SerializedName("solutionPath") protected Integer solutionPath;
    @SerializedName("runTime") protected Double runTime;
}
