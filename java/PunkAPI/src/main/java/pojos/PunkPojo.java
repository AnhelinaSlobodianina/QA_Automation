package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class PunkPojo implements Pojo {

    @JsonProperty("id")
    @NotNull
    public int id;

    @JsonProperty("name")
    @NotNull
    public String name;

    @JsonProperty("tagline")
    public String tagline;

    @JsonProperty("first_brewed")
    public String first_brewed;

    @JsonProperty("description")
    public String description;

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("abv")
    public double abv;

    @JsonProperty("ibu")
    public double ibu;

    @JsonProperty("target_fg")
    public double target_fg;

    @JsonProperty("target_og")
    public double target_og;

    @JsonProperty("ebc")
    public double ebc;

    @JsonProperty("srm")
    public double srm;

    @JsonProperty("ph")
    public double ph;

    @JsonProperty("attenuation_level")
    public double attenuation_level;

    @JsonProperty("volume")
    public Volume volume;

    @JsonProperty("boil_volume")
    public BoilVolume boil_volume;

    @JsonProperty("method")
    public Method method;

    @JsonProperty("ingredients")
    public Ingredients ingredients;

    @JsonProperty("food_pairing")
    public ArrayList<String> food_pairing;

    @JsonProperty("brewers_tips")
    public String brewers_tips;

    @JsonProperty("contributed_by")
    public String contributed_by;
}