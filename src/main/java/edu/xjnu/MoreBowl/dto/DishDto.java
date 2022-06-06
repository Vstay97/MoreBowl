package edu.xjnu.MoreBowl.dto;

import edu.xjnu.MoreBowl.entity.Dish;
import edu.xjnu.MoreBowl.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
