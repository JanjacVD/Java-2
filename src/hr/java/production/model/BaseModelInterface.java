package hr.java.production.model;

import java.util.Map;

public interface BaseModelInterface {
    public static <T extends BaseModel> T create(Class<T> clazz, Map<String, Object> data){
        return null;
    };
}
